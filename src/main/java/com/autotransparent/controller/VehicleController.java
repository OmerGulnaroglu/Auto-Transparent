package com.autotransparent.controller;

import com.autotransparent.dto.VehicleRequest;
import com.autotransparent.model.Vehicle;
import com.autotransparent.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usta/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add")
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleRequest request) {
        Vehicle savedVehicle = vehicleService.saveVehicle(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }
}
