package app.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Location;
import app.repositories.LocationRepository;

@Component
public class LocationInitializer {

    @Autowired
    private LocationRepository locationRepository;

    @PostConstruct
    public void initializeLocations() {
        if (locationRepository.count() == 0) {
            locationRepository.save(new Location("Faura", 14.639722, 121.078611));
            locationRepository.save(new Location("CTC", 14.637528, 121.074697));
            locationRepository.save(new Location("Bel", 14.637200, 121.075500));
            locationRepository.save(new Location("Berchmans", 14.638000, 121.076300));
            locationRepository.save(new Location("Gonz", 14.639000, 121.076800));
            locationRepository.save(new Location("New Rizal Library", 14.639100, 121.077500));
            locationRepository.save(new Location("Matteo", 14.637500, 121.075800));
            locationRepository.save(new Location("Leong", 14.639900, 121.078200));
            locationRepository.save(new Location("Kostka", 14.637800, 121.077800));
            locationRepository.save(new Location("SHS", 14.638300, 121.078600));
        }
    }
}