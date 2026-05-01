package com.autotransparent.controller;

import com.autotransparent.dto.CreateInspectionReportRequest;
import com.autotransparent.model.InspectionReport;
import com.autotransparent.model.Vehicle;
import com.autotransparent.service.UstaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usta")
public class UstaController {

    private final UstaService ustaService;

    public UstaController(UstaService ustaService) {
        this.ustaService = ustaService;
    }

    @GetMapping("/vehicles/search")
    public ResponseEntity<Vehicle> searchByPlate(@RequestParam String plate) {
        Vehicle vehicle = ustaService.searchVehicleByPlate(plate);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("/reports")
    public ResponseEntity<InspectionReport> addReport(@RequestBody CreateInspectionReportRequest request) {
        InspectionReport report = ustaService.addInspectionReport(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(report);
    }
}