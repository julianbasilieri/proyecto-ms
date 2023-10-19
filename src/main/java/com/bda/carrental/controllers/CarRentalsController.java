package com.bda.carrental.controllers;

import com.bda.carrental.entities.dto.CarRentalDto;
import com.bda.carrental.services.CarRentalsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carRentals")
public class CarRentalsController {
    private final CarRentalsService carRentalsService;

    public CarRentalsController(CarRentalsService carRentalsService) {
        this.carRentalsService = carRentalsService;
    }

    @GetMapping
    public ResponseEntity<List<CarRentalDto>> getAll() {
        List<CarRentalDto> values = carRentalsService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarRentalDto> getById(@PathVariable("id") Long id) {
        CarRentalDto value = carRentalsService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CarRentalDto entity) {
        carRentalsService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CarRentalDto entity) {
        carRentalsService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        carRentalsService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
