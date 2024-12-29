package com.org.simuladorformula1.models.repositories;

import com.org.simuladorformula1.models.entities.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotRepository extends JpaRepository<Pilot, Integer> {
}
