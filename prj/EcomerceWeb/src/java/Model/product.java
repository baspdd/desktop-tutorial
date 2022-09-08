/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Support.StringHelper;

/**
 *
 * @author kienb
 */
public class product {
    private int product_id;
    private String product_name;
    private String image;
    private double price;
    private String tiltle;
    private String description;
    private String model;
    private String color;
    private String image2;
    private String image3;
    private String image4;
    private int quantity;

    public product() {
    }

    public product(int product_id, String product_name, String image, double price, String tiltle, String description, String model, String color, String image2, String image3, String image4, int quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.image = image;
        this.price = price;
        this.tiltle = tiltle;
        this.description = description;
        this.model = model;
        this.color = color;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTiltle() {
        return tiltle;
    }

    public void setTiltle(String tiltle) {
        this.tiltle = tiltle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String displayPrice(){
        return StringHelper.printPrice(price);
    }
}
