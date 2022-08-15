package com.example.artsquarestationery;

public class User {
    public String name, username, shop_name, shop_address, phone_no, e_mail, password;

    public User(String name, String username, String shop_name, String shop_address, String phone_no, String e_mail, String password){
        this.name=name;
        this.username=username;
        this.shop_name=shop_name;
        this.shop_address=shop_address;
        this.phone_no=phone_no;
        this.e_mail=e_mail;
        this.password=password;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
