package com.org.simuladorformula1.controllers;

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
    public Iterable<Team> getAllTeams() {
        return teamService.showTeams();
    }
    @PutMapping("/update")
    public void updateTeam(Integer id, Team team) {

    }
    @DeleteMapping("/delete/{id}")
    public void deleteTeam(Integer id) {
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
