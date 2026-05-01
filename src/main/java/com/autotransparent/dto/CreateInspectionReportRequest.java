package com.autotransparent.dto;

public class CreateInspectionReportRequest {

    private String plate;
    private Long ustaId;
    private String serviceStatus;
    private String notes;
    private String paintStatus;
    private String mechanicalStatus;
    private String interiorStatus;
    private Integer overallScore;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getUstaId() {
        return ustaId;
    }

    public void setUstaId(Long ustaId) {
        this.ustaId = ustaId;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPaintStatus() {
        return paintStatus;
    }

    public void setPaintStatus(String paintStatus) {
        this.paintStatus = paintStatus;
    }

    public String getMechanicalStatus() {
        return mechanicalStatus;
    }

    public void setMechanicalStatus(String mechanicalStatus) {
        this.mechanicalStatus = mechanicalStatus;
    }

    public String getInteriorStatus() {
        return interiorStatus;
    }

    public void setInteriorStatus(String interiorStatus) {
        this.interiorStatus = interiorStatus;
    }

    public Integer getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
    }
}