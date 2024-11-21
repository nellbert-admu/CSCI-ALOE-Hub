package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Sighting;

@Repository
public interface SightingRepository extends JpaRepository<Sighting, Long> {
}