package com.org.simuladorformula1.controllers;

import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    ArrayList<Pilot> pilots = new ArrayList<>(30);

    @Autowired
    private PilotRepository pilotRepository;

    @PostMapping("/add")
    public Pilot addPilot() {
        if(pilots.size() >= 30) {
            return null;
        }
        try{
            Pilot pilot = new Pilot(20, "João", 150, 150, 1500);
            pilotRepository.save(pilot);
            return pilot;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @GetMapping("/search")
    public Iterable<Pilot> searchPilot() {
        return pilotRepository.findAll();
    }

    @PatchMapping("/parcialUpdate")
    public Pilot updatePilotCompletely() {
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

    @DeleteMapping("/delete")
    public void deletPilot() {

    }

}

