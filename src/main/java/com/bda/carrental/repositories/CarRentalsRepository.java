package com.bda.carrental.repositories;

import com.bda.carrental.entities.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRentalsRepository
        extends JpaRepository<CarRental, Long> {
}
