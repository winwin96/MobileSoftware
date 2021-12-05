package com.course.project;

public class Products {

    String product_name;
    int product_images;
    int product_image;
    String product_url;
    String product_description;
    String product_price;

    public Products (int first_pic, int second_pic, String name, String description, String price, String url) {
        this.product_image = first_pic;
        this.product_images = second_pic;
        this.product_name = name;
        this.product_url = url;
        this.product_description = description;
        this.product_price = price;
    }
    public String getProductName() {
        return product_name;
    }
    public int getFirstImage() {
        return product_image;
    }
    public int getSecondImage() {
        return product_images;
    }
    public String getURL() {
        return product_url;
    }
    public String getDescription() {
        return product_description;
    }
    public String getPrice() {
        return product_price;
    }
}
