package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.StrayAnimal;  

@Repository
public interface StrayAnimalRepository extends JpaRepository<StrayAnimal, Long> {

    List<StrayAnimal> findByType(String type);

    List<StrayAnimal> findByNeutered(boolean neutered);
}