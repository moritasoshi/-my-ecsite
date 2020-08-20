package com.example.myecsite.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterUserForm {
    private Integer id;

    @NotBlank(message = "名前を入力してください")
    private String name;

    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "メールアドレスの形式が不正です")
    private String email;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 8, max = 16, message = "パスワードは８文字以上１６文字以内で設定してください")
    private String password;

    @NotBlank(message = "郵便番号を入力してください")
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}", message = "郵便番号はXXX-XXXXの形式で入力してください")
    private String zipcode;

    @NotBlank(message = "住所を入力してください")
    private String address;

    @NotBlank(message = "電話番号を入力して下さい")
    @Pattern(regexp = "[0-9]{1,4}-[0-9]{1,4}-[0-9]{1,4}", message = "電話番号はXXXX-XXXX-XXXXの形式で入力してください")
    private String telephone;

    @NotBlank(message = "確認用パスワードを入力してください")
    private String verificationPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVerificationPassword() {
        return verificationPassword;
    }

    public void setVerificationPassword(String verificationPassword) {
        this.verificationPassword = verificationPassword;
    }
}
