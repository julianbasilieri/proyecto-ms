package com.bda.carrental.services.transformations.carRentals;

import com.bda.carrental.entities.CarRental;
import com.bda.carrental.entities.dto.CarRentalDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class CarRentalsMapper implements Function<CarRentalDto, CarRental> {
    @Override
    public CarRental apply(CarRentalDto carRentalDto) {
        return new CarRental(carRentalDto.getId(),
                carRentalDto.getRentalDate(),
                carRentalDto.getReturnedDate(),
                carRentalDto.isPayed());
    }
}
