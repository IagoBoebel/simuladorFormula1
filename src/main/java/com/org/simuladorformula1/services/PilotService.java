package com.org.simuladorformula1.services;

import com.org.simuladorformula1.dto.PilotDTO;
import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.entities.Team;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import com.org.simuladorformula1.models.repositories.TeamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PilotService {

    @Autowired
    private PilotRepository pilotRepository;
    @Autowired
    private TeamRepository teamRepository;

    public Pilot addPilot(Pilot pilot) {
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

    public Pilot updateParcial(Integer id, String name, Integer age, Double salary, List<String> sponsors, Integer championPosition, String team) {
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

    public void excludePilot(int id) {
        if (pilotRepository.existsById(id)) {
            // Remove o piloto do BD
            pilotRepository.deleteById(id);
        }
    }

    public void deleteAllPilots() {
        pilotRepository.deleteAll();
    }

    public Iterable<PilotDTO> listPilotsWithTeam() {
        return pilotRepository.findAllPilotsWithTeamName();
    }
    public Iterable<PilotDTO> listPilotWithoutTeam() {return pilotRepository.findAllPilotsWithoutTeamName();}
    public Pilot listByName(String name) {return pilotRepository.findByNameIgnoreCase(name);}
    public Optional<Pilot> searchById(Integer id) {return pilotRepository.findById(id);}

}
