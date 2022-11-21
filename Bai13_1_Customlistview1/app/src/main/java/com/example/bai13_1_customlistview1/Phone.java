package com.example.bai13_1_customlistview1;

public class Phone {
    private int image;
    private String namePhone, pricePhone;

    public int getImage() {
        return image;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public String getPricePhone() {
        return pricePhone;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public void setPricePhone(String pricePhone) {
        this.pricePhone = pricePhone;
    }

    public Phone(int image, String namePhone, String pricePhone) {
        this.image = image;
        this.namePhone = namePhone;
        this.pricePhone = pricePhone;
    }
}
