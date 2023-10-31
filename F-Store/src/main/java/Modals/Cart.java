/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modals;

/**
 *
 * @author admin
 */
public class Cart {

    private int magiohang;
    private int makhachhang;
    private int masanpham;
    private String kichthuocsanpham;
    private int soluong;
    
    public Cart() {
    }

    public Cart(int magiohang, int makhachhang, int masanpham, String kichthuocsanpham, int soluong) {
        this.magiohang = magiohang;
        this.makhachhang = makhachhang;
        this.masanpham = masanpham;
        this.kichthuocsanpham = kichthuocsanpham;
        this.soluong = soluong;
    }

    public Cart(int makhachhang, int masanpham, String kichthuocsanpham, int soluong) {
        this.magiohang = magiohang;
        this.makhachhang = makhachhang;
        this.masanpham = masanpham;
        this.kichthuocsanpham = kichthuocsanpham;
        this.soluong = soluong;
    }

    public int getMagiohang() {
        return magiohang;
    }

    public void setMagiohang(int magiohang) {
        this.magiohang = magiohang;
    }

    public int getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(int makhachhang) {
        this.makhachhang = makhachhang;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public String getKichthuocsanpham() {
        return kichthuocsanpham;
    }

    public void setKichthuocsanpham(String kichthuocsanpham) {
        this.kichthuocsanpham = kichthuocsanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
