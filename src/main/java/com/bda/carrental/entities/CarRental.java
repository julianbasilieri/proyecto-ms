package com.bda.carrental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "car_rentals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRental {
    @Id
    @GeneratedValue(generator = "car_rental")
    @TableGenerator(name = "car_rental", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="id",
            initialValue=1, allocationSize=1)

    private long id;
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;
    @Column(name = "returned_date")
    private LocalDateTime returnedDate;
    private boolean payed;
}
