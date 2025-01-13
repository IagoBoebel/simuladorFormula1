package com.org.simuladorformula1.models.repositories;

import com.org.simuladorformula1.dto.PilotDTO;
import com.org.simuladorformula1.dto.TeamDTO;
import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
    Optional<Team> findByName(String teamName);

    boolean existsByName(String teamName);

    @Query("""
    SELECT new com.org.simuladorformula1.dto.TeamDTO(
        t.id, 
        t.name, 
        t.car, 
        t.teamPrincipal
    )
    FROM Team t
""")
    Iterable<TeamDTO> findTeamWithBasicInfo();






}



