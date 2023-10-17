package com.bda.carrental.services;

import com.bda.carrental.entities.CarRental;
import com.bda.carrental.entities.dto.CarRentalDto;
import com.bda.carrental.repositories.CarRentalsRepository;
import com.bda.carrental.services.transformations.carRentals.CarRentalDtoMapper;
import com.bda.carrental.services.transformations.carRentals.CarRentalsMapper;

import java.util.List;

public class CarRentalsServiceImpl implements CarRentalsService{
    private final CarRentalsRepository carRentalsRepository;
    private final CarRentalDtoMapper carRentalDtoMapper;
    private final CarRentalsMapper carRentalsMapper;

    public CarRentalsServiceImpl(CarRentalsRepository carRentalsRepository, CarRentalDtoMapper carRentalDtoMapper, CarRentalsMapper carRentalsMapper) {
        this.carRentalsRepository = carRentalsRepository;
        this.carRentalDtoMapper = carRentalDtoMapper;
        this.carRentalsMapper = carRentalsMapper;
    }

    @Override
    public void add(CarRentalDto entity) {
        CarRental carRental = new CarRental();
        carRental.setRentalDate(entity.getRentalDate());
        carRental.setReturnedDate(entity.getReturnedDate());
        carRental.setPayed(entity.isPayed());
        carRentalsRepository.save(carRental);
    }

    @Override
    public CarRentalDto getById(Long id) {
        return null;
    }

    @Override
    public List<CarRentalDto> getAll() {
        return null;
    }

    @Override
    public CarRentalDto delete(Long id) {
        return null;
    }

    @Override
    public void update(CarRentalDto entity) {

    }
}
