package com.example.myecsite.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 注文情報を表すドメイン.
 *
 * @author yumi takahashi
 */
public class Order {

    /**
     * ID
     */
    private Integer id;

    /**
     * ユーザID
     */
    private Integer userId;

    /**
     * 状態
     */
    private Integer status;

    /**
     * 合計金額
     */
    private Integer totalPrice;

    /**
     * 注文日
     */
    private Date orderDate;

    /**
     * 宛先氏名
     */
    private String destinationName;

    /**
     * 宛先Eメール
     */
    private String destinationEmail;

    /**
     * 宛先郵便番号
     */
    private String destinationZipcode;

    /**
     * 宛先住所
     */
    private String destinationAddress;

    /**
     * 宛先TEL
     */
    private String destinationTel;

    /**
     * 配達時間
     */
    private Timestamp deliveryTime;

    /**
     * 支払方法
     */
    private Integer paymentMethod;

    public Order() {
    }

    public Order(Integer id, Integer userId, Integer status, Integer totalPrice, Date orderDate, String destinationName, String destinationEmail, String destinationZipcode, String destinationAddress, String destinationTel, Timestamp deliveryTime, Integer paymentMethod) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.destinationName = destinationName;
        this.destinationEmail = destinationEmail;
        this.destinationZipcode = destinationZipcode;
        this.destinationAddress = destinationAddress;
        this.destinationTel = destinationTel;
        this.deliveryTime = deliveryTime;
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationEmail() {
        return destinationEmail;
    }

    public void setDestinationEmail(String destinationEmail) {
        this.destinationEmail = destinationEmail;
    }

    public String getDestinationZipcode() {
        return destinationZipcode;
    }

    public void setDestinationZipcode(String destinationZipcode) {
        this.destinationZipcode = destinationZipcode;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getDestinationTel() {
        return destinationTel;
    }

    public void setDestinationTel(String destinationTel) {
        this.destinationTel = destinationTel;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
