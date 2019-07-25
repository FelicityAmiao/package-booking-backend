package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Packages;
import com.oocl.packagebooking.repository.PackageRepository;
import com.oocl.packagebooking.service.PackageService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PackageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PackageRepository packageRepository;

    @Test
    public void should_return_packages_when_call_getAllPackages() throws Exception {

        Packages package1 = new Packages();
        package1.setWaybillId(1l);
        package1.setUserName("Amiao");
        package1.setPhone("15222366954");
        package1.setStatus("未取件");
        package1.setOrderTime("2019-07-25 20:16:46");
        package1.setWeight("3KG");

        ArrayList<Packages> objects = new ArrayList<>();
        objects.add(package1);
        given(packageRepository.findAll()).willReturn(objects);

        mockMvc.perform(get("/packages"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string("[{\"waybillId\":1,\"userName\":\"Amiao\",\"phone\":\"15222366954\",\"status\":\"未取件\",\"orderTime\":\"2019-07-25 20:16:46\",\"weight\":\"3KG\"}]"));
    }

}