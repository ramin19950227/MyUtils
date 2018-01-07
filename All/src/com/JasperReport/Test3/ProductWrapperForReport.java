/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.JasperReport.Test3;

/**
 *
 * @author Ramin
 */
public class ProductWrapperForReport {

    private String name;
    private String qty;
    private String purchasePrice;
    private String totalPrice;
    private String barCode;

    public ProductWrapperForReport(Product p) {
        this.name = p.getName();
        this.qty = p.getQty().toString();
        this.purchasePrice = p.getPurchasePrice().toString();
        this.totalPrice = Double.toString(p.getQty() * p.getPurchasePrice());
        this.barCode = p.getBarCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

}
