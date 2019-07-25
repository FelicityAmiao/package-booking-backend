package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Packages, Long> {
    List<Packages> findByStatus(String status);
}
