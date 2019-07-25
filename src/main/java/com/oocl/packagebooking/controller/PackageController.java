package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Packages;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping
    public List<Packages> getAllPackages() {
        return packageService.getAllPackages();
    }

    @PostMapping
    public Packages addAPackages(@RequestBody Packages packages) {
        return  packageService.add(packages);
    }

    @GetMapping(params = {"status"})
    public List<Packages> getPackagesByStatus(@RequestParam String status) {
        return packageService.getPackagesByStatus(status);
    }
}
