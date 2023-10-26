/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modals;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class cart {
    private int cartID;
    private int userID;
    private String productID;
    private double totalPrice;
    private String size;
    private int quantity;

    public cart() {
    }

    public cart(int cartID, int userID, String productID, double totalPrice, String size, int quantity) {
        this.cartID = cartID;
        this.userID = userID;
        this.productID = productID;
        this.totalPrice = totalPrice;
        this.size = size;
        this.quantity = quantity;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    private List<Items> items;
    
    public cart(List<Items> items){
        this.items = items;
    }
    
    public List<Items> getItems(){
        return items;
    }
    
    public void setItems(List<Items> items){
        this.items = items;
    }

    //Get item by ID
    private Items getItemsByID(int id){
        for (Items o : items){
            if(o.getProduct().getProductID() == id){
                return o;
            }
        }
        return null;
    }
    
    //Get QuantityByID
    public int getQuantityByID(int id){
        return getItemsByID(id).getQuantity();// Lay quantity cua item
    }
    
    //Add items
    public void addItem(Items t){
        if(getItemsByID(t.getProduct().getProductQuantity()) != null){
            Items m = getItemsByID(t.getProduct().getProductQuantity());
            m.setQuantity(m.getQuantity() + t.getQuantity()); // so luong cu + moi
        }else{
            items.add(t);
        }
    }
    
    //Remove items
    public void removeItem(int id){
        if(getItemsByID(id)!=null){
            items.remove(getItemsByID(id));
        }
    }
    
    //Total price
    public double gettotalPrice(){
        double t = 0;
        for(Items o : items){
            t += (o.getQuantity() * o.getPrice());
        }
        return t;
    }
    
    //getProductByID
    private Product getProductByID(int id, List<Product> list){
        for (Product o : list){
            if(o.getProductID() == id){
                return o;
            }
        }
        return null;
    }
    
    public cart(String txt , List<Product> list){
        items = new ArrayList<>();
        try{
            if(txt != null && txt.length() != 0){
                String [] s = txt.split(",");
                for (String o : s){
                    String [] n = o.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product p = getProductByID(id, list);
                    Items t = new Items(p, quantity, totalPrice);
                    addItem(t);
                }
            }
        } catch (Exception e){           
        }
    }
}