package com.org.simuladorformula1.controllers;

import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    ArrayList<Pilot> pilots = new ArrayList<>(30);

    @Autowired
    private PilotRepository pilotRepository;

    @PostMapping("/add")
    public Pilot addPilot(@Valid Pilot pilot) {
        if(pilots.size() >= 30) {
            return null;
        }
        try{
            pilotRepository.save(pilot);
            pilots.add(pilot);
            return pilot;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @GetMapping("/search")
    public Iterable<Pilot> searchPilot() {
        return pilotRepository.findAll();
    }

    @GetMapping("/searchByName/{name}")
    public Pilot searchByName(@PathVariable String name) {
        return pilotRepository.findByNameIgnoreCase(name);
    }
    @GetMapping("/searchById/{id}")
    public Optional<Pilot> searchById(@PathVariable Integer id) {
        return pilotRepository.findById(id);
    }

    @PatchMapping("/parcialUpdate")
    public Pilot updatePilotCompletely(@Valid Pilot pilot) {
       return null;
    }

    @PutMapping("/completeUpdate")
    public Pilot updatePilotParcial(@Valid Pilot pilot) {
        if(pilot.getId() != null) {
            pilotRepository.save(pilot);
            return pilot;
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void deletePilot(@PathVariable int id) {
        if (pilotRepository.existsById(id)) {
            // Remove o piloto do BD
            pilotRepository.deleteById(id);
            // Remove o piloto do array de controle
            pilots.removeIf(pilot -> pilot.getId() == id);
        }
    }
    @DeleteMapping("/deleteAll")
    public void deleteAllPilots() {
        for(Pilot pilot : pilots) {
            pilots.remove(pilot);
            pilotRepository.deleteById(pilot.getId());
        }
    }

}

