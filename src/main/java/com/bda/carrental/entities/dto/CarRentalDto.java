package com.bda.carrental.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRentalDto {
    private long id;
    private LocalDateTime rentalDate;
    private LocalDateTime returnedDate;
    private boolean payed;

}
