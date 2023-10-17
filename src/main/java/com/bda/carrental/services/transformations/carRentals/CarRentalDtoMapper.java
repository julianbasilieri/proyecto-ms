package com.bda.carrental.services.transformations.carRentals;

import com.bda.carrental.entities.CarRental;
import com.bda.carrental.entities.dto.CarRentalDto;

import java.util.function.Function;

public class CarRentalDtoMapper implements Function<CarRental, CarRentalDto> {

    @Override
    public CarRentalDto apply(CarRental carRental) {
        return new CarRentalDto(carRental.getId(),
                carRental.getRentalDate(),
                carRental.getReturnedDate(),
                carRental.isPayed());
    }
}
