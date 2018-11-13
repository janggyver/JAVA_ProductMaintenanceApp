/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductMaintenance.business;

import java.text.NumberFormat;

/**
 *
 * @author eric
 */
public class Product implements Cloneable{
    //the instance variables
    private String code;
    private String description;
    private double price;
    
    //the constructor
    public Product(){
        code = "";
        description = "";
        price = 0.0;
    }

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }
    
    //setter and getter
    public void setCode(String code){
        this.code = code;
    }
    
    public String getCode(){
        return this.code;
    }
    
    public void setDescription(String desc){
        description = desc;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    
    //a custom get method for the price variable
    public String getFormattedPrice(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    
    //implementation for the interface
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    
    @Override
    public String toString(){
        return "Code: " + code + "\n"
                + "Description: " + description + "\n"
                + "Price: " + getFormattedPrice() + "\n";
    }
    
    public void setFormattedPrice(String price){
        this.price = Double.parseDouble(price);
    }
}
