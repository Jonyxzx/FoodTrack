package com.example.springboot.service;

import com.example.springboot.entity.Locations;
import com.example.springboot.repository.LocationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer is where all the business logic lies
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {
    private final LocationRepo locationRepo;

    public List<Locations> getAllLocations() {
        return locationRepo.findAll();
    }

    public Locations getLocationById(Integer id) {
        Optional<Locations> optionalLocation = locationRepo.findById(id);
        if (optionalLocation.isPresent()) {
            return optionalLocation.get();
        }

        log.info("Locations with id: {} doesn't exist", id);
        return null;
    }

    public Locations saveLocation(Locations Locations) {
        Locations savedLocation = locationRepo.save(Locations);

        log.info("Locations with id: {} saved successfully", Locations.getId());
        return savedLocation;
    }

    public Locations updateLocation(Locations Locations) {
        Optional<Locations> existingLocation = locationRepo.findById(Locations.getId());
        Locations updatedLocation = locationRepo.save(Locations);

        log.info("Locations with id: {} updated successfully", Locations.getId());
        return updatedLocation;
    }

    public void deleteLocationById(Integer id) {
        locationRepo.deleteById(id);
    }
}
