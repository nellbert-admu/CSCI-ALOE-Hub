
package app.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.StrayAnimal;
import app.repositories.StrayAnimalRepository;

@Component
public class StrayAnimalComponent {

    @Autowired
    private StrayAnimalRepository strayAnimalRepository;

    public List<StrayAnimal> getStrayAnimalsByType(String type) {
        return strayAnimalRepository.findByType(type);
    }

    public List<StrayAnimal> getNonNeuteredStrayAnimals() {
        return strayAnimalRepository.findByNeutered(false);
    }
    
    public Long saveStrayAnimal(StrayAnimal strayAnimal) {
        StrayAnimal savedStrayAnimal = strayAnimalRepository.save(strayAnimal);
        return savedStrayAnimal.getId();
    }
}
