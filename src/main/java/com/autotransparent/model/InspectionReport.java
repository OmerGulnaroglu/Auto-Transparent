package com.autotransparent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inspection_reports")
public class InspectionReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long serviceRecordId;

    @Column(nullable = false)
    private String paintStatus;

    @Column(nullable = false)
    private String mechanicalStatus;

    @Column(nullable = false)
    private String interiorStatus;

    @Column(nullable = false)
    private Integer overallScore;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getServiceRecordId() { return serviceRecordId; }
    public void setServiceRecordId(Long serviceRecordId) { this.serviceRecordId = serviceRecordId; }
    public String getPaintStatus() { return paintStatus; }
    public void setPaintStatus(String paintStatus) { this.paintStatus = paintStatus; }
    public String getMechanicalStatus() { return mechanicalStatus; }
    public void setMechanicalStatus(String mechanicalStatus) { this.mechanicalStatus = mechanicalStatus; }
    public String getInteriorStatus() { return interiorStatus; }
    public void setInteriorStatus(String interiorStatus) { this.interiorStatus = interiorStatus; }
    public Integer getOverallScore() { return overallScore; }
    public void setOverallScore(Integer overallScore) { this.overallScore = overallScore; }
}