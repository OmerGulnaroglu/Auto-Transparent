package com.autotransparent.service.impl;

import com.autotransparent.dto.VehicleRequest;
import com.autotransparent.model.User;
import com.autotransparent.model.Vehicle;
import com.autotransparent.repository.UserRepository;
import com.autotransparent.repository.VehicleRepository;
import com.autotransparent.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Vehicle saveVehicle(VehicleRequest request) {
        User owner = userRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new IllegalArgumentException("Kullanici bulunamadi: " + request.getOwnerId()));

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setPlate(request.getPlate());
        vehicle.setOwner(owner);

        return vehicleRepository.save(vehicle);
    }
}
