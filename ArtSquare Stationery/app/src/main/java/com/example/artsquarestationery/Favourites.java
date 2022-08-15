package com.example.artsquarestationery;

public class Favourites {
    public String name, item;

    public Favourites(String name, String item){
        this.name=name;
        this.item=item;
    }

    public Favourites() {

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
}
