package com.org.simuladorformula1.services;

import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.entities.Team;
import com.org.simuladorformula1.models.repositories.PilotRepository;
import com.org.simuladorformula1.models.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PilotRepository pilotRepository;

    //Recuperar team
    public Iterable<Team> showTeams() {
        return teamRepository.findAll();
    }

    //Adicionar team
    public Team addNewTeam(Team team) {
        if(teamRepository.count() > 10) {
            return null;
        }
        return teamRepository.save(team);
    }

    //Excluir team
    public void deleteTeam(Integer id) {
        teamRepository.deleteById(id);
    }

    //Adicionar pilotos ao team
    public void addPilots(Pilot pilot, Integer id) {
        Team team = teamRepository.getById(id);

        team.addPilot(pilot);

        pilotRepository.save(pilot);
        teamRepository.save(team);


    }


    //Set team principal

    //Adicionar Carro

    //Set Carro


}
