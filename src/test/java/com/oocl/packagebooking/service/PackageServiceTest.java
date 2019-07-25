package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Packages;
import com.oocl.packagebooking.exception.BookTimeException;
import com.oocl.packagebooking.repository.PackageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PackageServiceTest {

    @Autowired
    private PackageService packageService;

    @MockBean
    private PackageRepository packageRepository;

    @Test
    public void should_throw_bookTimeException_when_call_book_given_orderTime_less_than_9() throws BookTimeException{

        Packages packages = new Packages();
        packages.setWaybillId(11111124545L);

        when(packageRepository.findById(anyObject())).thenReturn(Optional.of(packages));
        assertThrows(BookTimeException.class, () -> packageService.book(11111124545L, "2019-07-25 08:30:00"));
    }
}