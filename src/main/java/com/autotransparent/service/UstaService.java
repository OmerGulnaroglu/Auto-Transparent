package com.autotransparent.service;

import com.autotransparent.dto.CreateInspectionReportRequest;
import com.autotransparent.model.InspectionReport;
import com.autotransparent.model.Vehicle;

public interface UstaService {
    Vehicle searchVehicleByPlate(String plate);
    InspectionReport addInspectionReport(CreateInspectionReportRequest request);
}
