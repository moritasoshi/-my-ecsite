package com.example.myecsite.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OrderForm {

    private Integer totalPrice;
    @NotBlank(message = "名前を入力してください")
    @Size(max = 50, message = "50文字以内で入力してください")
    private String destinationName;
    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "メールアドレスの形式が不正です")
    private String destinationEmail;
    @NotBlank(message = "郵便番号を入力してください")
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}", message = "郵便番号はXXX-XXXXの形式で入力してください")
    private String destinationZipcode;
    @NotBlank(message = "住所を入力してください")
    private String destinationAddress;
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "電話番号はXXX-XXXX-XXXXの形式で入力してください")
    private String destinationTel;
    @NotBlank(message = "配達時間を入力してください")
    private String deliveryTime;
    @NotBlank(message = "配達日を入力してください")
    private String deliveryDate;
    @NotNull(message = "支払い方法を選択してください")
    private Integer paymentMethod;

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
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

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
