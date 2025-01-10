package com.org.simuladorformula1.models.repositories;

import com.org.simuladorformula1.models.entities.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PilotRepository extends JpaRepository<Pilot, Integer> {

    @Query("SELECT COUNT(p) FROM Pilot p WHERE p.team = :teamName")
    int countPilotsByTeam(@Param("teamName") String teamName);

    public Pilot findByNameIgnoreCase(String nome);
}
