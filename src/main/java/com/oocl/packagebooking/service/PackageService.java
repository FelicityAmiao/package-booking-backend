package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Packages;
import com.oocl.packagebooking.exception.BookTimeException;
import com.oocl.packagebooking.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<Packages> getPackagesByStatus(String status) {
        return packageRepository.findByStatus(status);
    }

    public Packages modifyPackageStatus(Packages status) {
        return packageRepository.save(status);
    }

    public Packages book(Long waybillId, String orderTime) throws BookTimeException {
        String orderHour = orderTime.substring(orderTime.indexOf(":")-2, orderTime.indexOf(":"));
        Packages packages = null;
        if(Integer.parseInt(orderHour) >= 9 && Integer.parseInt(orderHour) < 20) {
            packages = packageRepository.findById(waybillId).orElse(null);
            if(packages == null) {
                throw new BookTimeException(BookTimeException.WAY_BILL_ID_IS_WRONG);
            }
            if(packages.getStatus() != null && packages.getStatus().equals("已预约")) {
                throw new BookTimeException(BookTimeException.NOT_ALLOW_BOOK_REPETITION);
            }
            try {
                packages.setOrderTime(orderTime);
            } catch (ParseException e) {
                throw new BookTimeException((BookTimeException.BOOK_FAIL));
            }
            packageRepository.save(packages);
        }else {
            throw new BookTimeException(BookTimeException.SHOULD_BETWEEN_NINE_AM_TO_EIGHT_PM);
        }
        return packages;
    }
}
