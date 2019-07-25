package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Packages;
import com.oocl.packagebooking.exception.BookTimeException;
import com.oocl.packagebooking.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/packages")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8086"}, maxAge = 1000L)
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

    @PutMapping
    public Packages modifyPackageStatus(@RequestBody Packages packages) {
        return packageService.modifyPackageStatus(packages);
    }

    @PutMapping(params = {"waybillId", "orderTime"})
    public Packages book(@RequestParam Long waybillId, @RequestParam String orderTime) throws BookTimeException, ParseException {
        return packageService.book(waybillId, orderTime);
    }
}
