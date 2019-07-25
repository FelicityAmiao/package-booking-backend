package com.oocl.packagebooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Packages {

    @Id
    private Long waybillId;
    private String userName;
    private String phone;
    private String status;
    private Long orderTime;
    private String weight;

    public Long getWaybillId() {
        return waybillId;
    }

    public void setWaybillId(Long waybillId) {
        this.waybillId = waybillId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderTime() {
        Long orderTime = this.orderTime;
        if (orderTime == null || orderTime == 0) return null;
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orderTime));
    }

    public void setOrderTime(String orderTime) throws ParseException {
        if (orderTime == null) this.orderTime = null;
        long time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderTime).getTime();
        this.orderTime = time;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
