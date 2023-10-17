package com.bda.carrental.services;

import com.bda.carrental.entities.Vehicle;
import com.bda.carrental.entities.dto.VehicleDto;

public interface VehicleService extends Service<VehicleDto, Long> {
    void updateMillas(Long id, float millas);
}
