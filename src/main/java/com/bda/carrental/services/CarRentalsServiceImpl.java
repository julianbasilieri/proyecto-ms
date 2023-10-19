package com.bda.carrental.services;

import com.bda.carrental.entities.CarRental;
import com.bda.carrental.entities.dto.CarRentalDto;
import com.bda.carrental.repositories.CarRentalsRepository;
import com.bda.carrental.services.transformations.carRentals.CarRentalDtoMapper;
import com.bda.carrental.services.transformations.carRentals.CarRentalsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
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
        Optional<CarRental> value = carRentalsRepository.findById(id);
        return value
                .map(carRentalDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<CarRentalDto> getAll() {
        List<CarRental> values = carRentalsRepository.findAll();
        return values
                .stream()
                .map(carRentalDtoMapper)
                .toList();
    }

    @Override
    public CarRentalDto delete(Long id) {
        Optional<CarRental> optionalCarRental = carRentalsRepository.findById(id);
        optionalCarRental.ifPresent(carRentalsRepository::delete);
        return optionalCarRental
                .map(carRentalDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(CarRentalDto entity) {
        Optional<CarRental> optionalCarRental = carRentalsRepository.findById(entity.getId());
        optionalCarRental.ifPresent(carRental -> {
            carRental.setRentalDate(entity.getRentalDate());
            carRental.setReturnedDate(entity.getReturnedDate());
            carRental.setPayed(entity.isPayed());
            carRentalsRepository.save(carRental);
        });
    }
}
