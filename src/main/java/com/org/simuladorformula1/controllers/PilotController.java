package com.org.simuladorformula1.controllers;

import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    @Autowired
    private PilotRepository pilotRepository;

    @PostMapping("/add")
    public Pilot addPilot() {
        try{
            Pilot pilot = new Pilot(20, "João", 150, 150, 1500);
            pilotRepository.save(pilot);
            return pilot;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
