package com.org.simuladorformula1.services;

import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.entities.Team;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import com.org.simuladorformula1.models.repositories.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PilotRepository pilotRepository;


    public Iterable<Team> showTeams() {
        return teamRepository.findAll();
    }

    public Team addNewTeam(Team team) {
        if(teamRepository.count() > 10) {
            return null;
        }
        return teamRepository.save(team);
    }
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

    public void addPilots(Integer teamId, Integer pilotId) {
        Team team = teamRepository.getById(teamId);
        Pilot pilot = pilotRepository.getById(pilotId);
        team.addPilot(pilot);
        pilot.setTeam(team);
        pilotRepository.save(pilot);
        teamRepository.save(team);
    }
    public void addTeamPrincipal(Integer teamId, String teamPrincipalName) {
        Team team = teamRepository.getById(teamId);
        team.setTeamPrincipal(teamPrincipalName);
        teamRepository.save(team);
    }
    public void addCar(Integer teamId, String car) {
        Team team = teamRepository.getById(teamId);
        team.setCar(car);
        teamRepository.save(team);
    }
    @Transactional
    public void updateTeam(Team team) {
        long teamCount = teamRepository.count();
        if (teamCount >= 10) {
            throw new IllegalStateException("Não é possível ter mais de 10 times.");
        }
        teamRepository.save(team);
    }

    public Team findOrCreateTeam(String teamName) {
        if(teamRepository.existsByName(teamName)) {
            Optional<Team> optionalTeam = teamRepository.findByName(teamName);
            Team team = optionalTeam.get();
            return team;
        }
        Team team = new Team();
        team.setName(teamName);
        teamRepository.save(team);
        return team;
    }

}
