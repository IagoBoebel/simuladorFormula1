package com.org.simuladorformula1.controllers;

import com.org.simuladorformula1.dto.PilotDTO;
import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.services.PilotService;
import com.org.simuladorformula1.services.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pilot")
public class PilotController {

    //Usar @RequestBody caso os parametros forem enviados com JSON

    @Autowired
    private PilotService pilotService;
    @Autowired
    private TeamService teamService;


    @PostMapping("/add")
    public Pilot addPilot(@Valid Pilot pilot) {
        return pilotService.addPilot(pilot);
    }
    @GetMapping("/searchWithTeam")
    public Iterable<PilotDTO> searchPilot() {return pilotService.listPilotsWithTeam();}

    @GetMapping("/searchWithoutTeam")
    public Iterable<PilotDTO> searchPilotWithout() {
        return pilotService.listPilotWithoutTeam();
    }

    @GetMapping("/searchByName/{name}")
    public Pilot searchByName(@PathVariable String name) {
        return pilotService.listByName(name);
    }

    @GetMapping("/searchById/{id}")
    public Optional<Pilot> searchById(@PathVariable Integer id) {
        return pilotService.searchById(id);
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

        return pilotService.updateParcial(id, name, age, salary, sponsors, championPosition, team);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePilot(@PathVariable int id) {
        pilotService.excludePilot(id);
    }
    @DeleteMapping("/deleteAll")
    public void deleteAllPilots() {
        pilotService.deleteAllPilots();
    }

}

