package com.org.simuladorformula1.controllers;

import com.org.simuladorformula1.dto.PilotDTO;
import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.entities.Team;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import com.org.simuladorformula1.models.repositories.TeamRepository;
import com.org.simuladorformula1.services.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    //Usar @RequestBody caso os parametros forem enviados com JSON

    @Autowired
    private PilotRepository pilotRepository;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/add")
    public Pilot addPilot(@Valid Pilot pilot) {
        if(pilotRepository.count() >= 30) {
            return null;
        }
        try{
            pilotRepository.save(pilot);
            return pilot;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @GetMapping("/searchWithTeam")
    public Iterable<PilotDTO> searchPilot() {
        return pilotRepository.findAllPilotsWithTeamName();
    }

    @GetMapping("/searchWithoutTeam")
    public Iterable<PilotDTO> searchPilotWithout() {
        return pilotRepository.findAllPilotsWithoutTeamName();
    }


    @GetMapping("/searchByName/{name}")
    public Pilot searchByName(@PathVariable String name) {
        return pilotRepository.findByNameIgnoreCase(name);
    }

    @GetMapping("/searchById/{id}")
    public Optional<Pilot> searchById(@PathVariable Integer id) {
        return pilotRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public Pilot updatePilotParcial(
            @PathVariable Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Double salary,
            @RequestParam(required = false) List<String> sponsors,
            @RequestParam(required = false) Integer championPosition,
            @RequestParam(required = false) String team) {

        // Recupera o piloto existente
        Pilot existingPilot = pilotRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Piloto com ID " + id + " não encontrado."));

        // Atualiza apenas os campos presentes nos parâmetros
        if (name != null) {
            existingPilot.setName(name);
        }
        if (age != null) {
            existingPilot.setAge(age);
        }
        if (salary != null) {
            existingPilot.setSalary(salary);
        }
        if (sponsors != null) {
            existingPilot.setSponsors(new ArrayList<>(sponsors));
        }
        if (championPosition != null) {
            existingPilot.setChampionPosition(championPosition);
        }
        if (team != null) {
            if (!teamRepository.existsByName(team)) {
                throw new IllegalArgumentException("O time " + team + " não existe.");
            }
            Team existingTeam = teamRepository.findByName(team)
                    .orElseThrow(() -> new IllegalArgumentException("O time não foi encontrado no repositório."));
            existingPilot.setTeam(existingTeam);
        }

        // Salva e retorna o piloto atualizado
        return pilotRepository.save(existingPilot);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePilot(@PathVariable int id) {
        if (pilotRepository.existsById(id)) {
            // Remove o piloto do BD
            pilotRepository.deleteById(id);
        }
    }
    @DeleteMapping("/deleteAll")
    public void deleteAllPilots() {
        pilotRepository.deleteAll();

    }

}

