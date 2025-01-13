package com.org.simuladorformula1.controllers;

import com.org.simuladorformula1.dto.TeamDTO;
import com.org.simuladorformula1.models.entities.Team;
import com.org.simuladorformula1.models.repositories.TeamRepository;
import com.org.simuladorformula1.services.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/add")
    public Team addTeam(@Valid Team team) {
       return teamService.addNewTeam(team);
    }
    @GetMapping("/search")
    public Iterable<TeamDTO> getAllTeams() {
        return teamService.showTeams();
    }
    @PutMapping("/update/{id}")
    public void updateTeam(@PathVariable Integer id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String car,
                           @RequestParam(required = false) String teamPrincipal,
                           @RequestParam(required = false) String pilot1,
                           @RequestParam(required = false) String pilot2) {
        teamService.updateTeam(id, name, car, teamPrincipal, pilot1, pilot2);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
    }

    @PatchMapping("/newTeamPrincipal/{id}")
    public void updateTeamPrincipal(@PathVariable Integer id, @RequestParam String newPrincipal) {
        teamService.addTeamPrincipal(id, newPrincipal);
    }
    @PatchMapping("/newCar/{id}")
    public void updateCar(@PathVariable Integer id, @RequestParam String car) {
        teamService.addCar(id, car);
    }
    @PatchMapping("/newPilot/{teamId}")
    public void newPilot(@PathVariable Integer teamId, @RequestParam Integer pilotId) {
        teamService.addPilots(teamId, pilotId);
    }

}
