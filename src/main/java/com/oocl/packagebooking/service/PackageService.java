package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Packages;
import com.oocl.packagebooking.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    public List<Packages> getAllPackages() {
        return packageRepository.findAll();
    }

    public Packages add(Packages packages) {
        return packageRepository.save(packages);
    }
}
