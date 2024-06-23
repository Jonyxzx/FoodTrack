package com.example.springboot.repository;

import com.example.springboot.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository is an interface that provides access to a data in a database
 */
public interface LocationRepo extends JpaRepository<Locations, Integer> {
}
