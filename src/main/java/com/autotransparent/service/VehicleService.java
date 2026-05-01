package com.autotransparent.service;

import com.autotransparent.dto.VehicleRequest;
import com.autotransparent.model.Vehicle;

public interface VehicleService {
    Vehicle saveVehicle(VehicleRequest request);
}
