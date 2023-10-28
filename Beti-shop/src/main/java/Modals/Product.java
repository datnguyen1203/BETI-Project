/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modals;

/**
 *
 * @author uchih
 */
public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String productImg;
        private String productCategory;

    private String productMarterial;
    private String productType;

    public Product(int productID, String productName, double productPrice, int productQuantity, String productImg, String productCategory) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImg = productImg;
        this.productCategory = productCategory;
    }

    public Product() {
    }

    public Product(int productID, String productName, double productPrice, int productQuantity, String productImg, String productMarterial, String productType) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImg = productImg;
        this.productMarterial = productMarterial;
        this.productType = productType;
    }

    public Product(int productID, String productName, double productPrice, int productQuantity, String productImg, String productCategory, String productMarterial, String productType) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productImg = productImg;
        this.productCategory = productCategory;
        this.productMarterial = productMarterial;
        this.productType = productType;
    }
    

    public String getProductMarterial() {
        return productMarterial;
    }

    public void setProductMarterial(String productMarterial) {
        this.productMarterial = productMarterial;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productImg=" + productImg + ", productCategory=" + productCategory + ", productMarterial=" + productMarterial + ", productType=" + productType + '}';
    }
}
