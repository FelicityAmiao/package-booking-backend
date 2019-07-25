package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Packages, Long> {
}
