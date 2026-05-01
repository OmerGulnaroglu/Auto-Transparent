package com.autotransparent.service.impl;

import com.autotransparent.dto.CreateInspectionReportRequest;
import com.autotransparent.model.InspectionReport;
import com.autotransparent.model.ServiceRecord;
import com.autotransparent.model.Vehicle;
import com.autotransparent.repository.InspectionReportRepository;
import com.autotransparent.repository.ServiceRecordRepository;
import com.autotransparent.repository.VehicleRepository;
import com.autotransparent.service.UstaService;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UstaServiceImpl implements UstaService {

    private final VehicleRepository vehicleRepository;
    private final ServiceRecordRepository serviceRecordRepository;
    private final InspectionReportRepository inspectionReportRepository;

    public UstaServiceImpl(
            VehicleRepository vehicleRepository,
            ServiceRecordRepository serviceRecordRepository,
            InspectionReportRepository inspectionReportRepository) {
        this.vehicleRepository = vehicleRepository;
        this.serviceRecordRepository = serviceRecordRepository;
        this.inspectionReportRepository = inspectionReportRepository;
    }

    @Override
    public Vehicle searchVehicleByPlate(String plate) {
        return vehicleRepository.findByPlate(plate)
                .orElseThrow(() -> new IllegalArgumentException("Arac bulunamadi: " + plate));
    }

    @Override
    @Transactional
    public InspectionReport addInspectionReport(CreateInspectionReportRequest request) {
        Vehicle vehicle = searchVehicleByPlate(request.getPlate());

        ServiceRecord serviceRecord = new ServiceRecord();
        serviceRecord.setVehicleId(vehicle.getId());
        serviceRecord.setUstaId(request.getUstaId());
        serviceRecord.setDate(LocalDate.now());
        serviceRecord.setStatus(request.getServiceStatus());
        serviceRecord.setNotes(request.getNotes());

        ServiceRecord savedServiceRecord = serviceRecordRepository.save(serviceRecord);

        InspectionReport inspectionReport = new InspectionReport();
        inspectionReport.setServiceRecordId(savedServiceRecord.getId());
        inspectionReport.setPaintStatus(request.getPaintStatus());
        inspectionReport.setMechanicalStatus(request.getMechanicalStatus());
        inspectionReport.setInteriorStatus(request.getInteriorStatus());
        inspectionReport.setOverallScore(request.getOverallScore());

        return inspectionReportRepository.save(inspectionReport);
    }
}