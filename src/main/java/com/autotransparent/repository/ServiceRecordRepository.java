package com.autotransparent.repository;

import com.autotransparent.model.ServiceRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRecordRepository extends JpaRepository<ServiceRecord, Long> {
    List<ServiceRecord> findByVehicleId(Long vehicleId);
}
