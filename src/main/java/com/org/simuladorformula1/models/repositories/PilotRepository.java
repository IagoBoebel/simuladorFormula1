package com.org.simuladorformula1.models.repositories;

import com.org.simuladorformula1.dto.PilotDTO;
import com.org.simuladorformula1.models.entities.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Integer> {

    @Query("SELECT COUNT(p) FROM Pilot p WHERE p.team = :teamName")
    int countPilotsByTeam(@Param("teamName") String teamName);

    @Query("""
    SELECT new com.org.simuladorformula1.dto.PilotDTO(
        p.id, p.name, p.age, p.salary, p.sponsors, p.championPosition, p.team.name
    )
    FROM Pilot p
""")
    Iterable<PilotDTO> findAllPilotsWithTeamName();



    public Pilot findByNameIgnoreCase(String nome);
}
