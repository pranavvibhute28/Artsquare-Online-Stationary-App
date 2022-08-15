package com.example.artsquarestationery;

public class Delivery {
    String name,item,quantity,price,address,totalprice,contact;

    public Delivery(String name, String item, String quantity, String price, String address, String totalprice, String contact) {
        this.name = name;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.address = address;
        this.totalprice = totalprice;
        this.contact = contact;
    }

    public Delivery() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
