package com.org.simuladorformula1.services;

import com.org.simuladorformula1.dto.TeamDTO;
import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.entities.Team;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import com.org.simuladorformula1.models.repositories.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PilotRepository pilotRepository;


    public List<TeamDTO> showTeams() {
        List<TeamDTO> teams = (List<TeamDTO>) teamRepository.findTeamWithBasicInfo();

        // Preenche a lista de pilotos para cada time
        for (TeamDTO teamDTO : teams) {
            List<String> pilotNames = pilotRepository.findPilotNamesByTeamId(teamDTO.getId());
            teamDTO.setPilotNames(pilotNames);
        }

        return teams;
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
    public void updateTeam(Integer id, String name, String car, String teamPrincipal, String pilot1, String pilot2) {
        Team existingTeam = teamRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("O time não existe"));
        List<Pilot> pilots = new ArrayList<>();
        if(name != null) {
            existingTeam.setName(name);
        } if(car != null) {
            existingTeam.setCar(car);
        } if(teamPrincipal != null) {
            existingTeam.setTeamPrincipal(teamPrincipal);
        } if(pilot1 != null && pilotRepository.existsByName(pilot1)) {
            Pilot pilot = pilotRepository.findByNameIgnoreCase(pilot1);
            existingTeam.addPilot(pilot);
        } if(pilot2 != null && pilotRepository.existsByName(pilot2)) {
            Pilot pilot = pilotRepository.findByNameIgnoreCase(pilot2);
            existingTeam.addPilot(pilot);
        }

        teamRepository.save(existingTeam);
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

    public List<Pilot> addNewPilot(String name, Integer teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("Time não existe"));
        Pilot pilot = pilotRepository.findByNameIgnoreCase(name);
        List<Pilot> pilots = team.getPilots();
        if(pilots.size() < 2 ) {
            pilots.add(pilot);
        }
        return pilots;
    }

}
