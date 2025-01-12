package com.org.simuladorformula1.models.repositories;

import com.org.simuladorformula1.models.entities.Pilot;
import com.org.simuladorformula1.models.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
    Optional<Team> findByName(String teamName);

    boolean existsByName(String teamName);
}
