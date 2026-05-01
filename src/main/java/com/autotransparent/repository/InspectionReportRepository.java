package com.autotransparent.repository;

import com.autotransparent.model.InspectionReport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionReportRepository extends JpaRepository<InspectionReport, Long> {
    List<InspectionReport> findByServiceRecordId(Long serviceRecordId);
}
