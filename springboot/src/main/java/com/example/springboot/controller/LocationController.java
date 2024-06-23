package com.example.springboot.controller;

import com.example.springboot.entity.Locations;
import com.example.springboot.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class is where all the user requests are handled and required responses are sent
 */
@RestController
@RequestMapping("/foodtrack/v1")
@RequiredArgsConstructor
@Validated
public class LocationController {
    private final LocationService locationService;

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/foodtrack/v1/location
     * Purpose: Fetches all the locations in the Locations table
     * @return List of Locations
     */
    @GetMapping("/location")
    public ResponseEntity<List<Locations>> getAllLocations() {
        return ResponseEntity.ok().body(locationService.getAllLocations());
    }

    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/foodtrack/v1/location/1 (or any other id)
     * Purpose: Fetches Locations with the given id
     * @param id - Locations id
     * @return Locations with the given id
     */
    @GetMapping("/location/{id}")
    public ResponseEntity<Locations> getLocationById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(locationService.getLocationById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/foodtrack/v1/location
     * Purpose: Save a Locations entity
     * @param Locations - Request body is an Locations entity
     * @return Saved Locations entity
     */
    @PostMapping("/location")
    public ResponseEntity<Locations> saveLocation(@RequestBody Locations Locations) {
        return ResponseEntity.ok().body(locationService.saveLocation(Locations));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/foodtrack/v1/location
     * Purpose: Update a Locations entity
     * @param Locations - Locations entity to be updated
     * @return Updated Locations
     */
    @PutMapping("/location")
    public ResponseEntity<Locations> updateLocation(@RequestBody Locations Locations) {
        return ResponseEntity.ok().body(locationService.updateLocation(Locations));
    }

    /**
     * This method is called when a DELETE request is made
     * URL: localhost:8080/foodtrack/v1/location/1 (or any other id)
     * Purpose: Delete a Locations entity
     * @param id - Locations's id to be deleted
     * @return a String message indicating Locations record has been deleted successfully
     */
    @DeleteMapping("/location/{id}")
    public ResponseEntity<String> deleteLocationById(@PathVariable Integer id) {
        locationService.deleteLocationById(id);
        return ResponseEntity.ok().body("Deleted Locations successfully");
    }
}
