package com.info.model;

import java.sql.Timestamp;

public class BillingDetails {
private int id;
private int CustomerID;
private int Bill_No;
private String Bill_Name;
private int Reading_Value;
private int Units;
private Double Reading_Bill;
private Double Fine;
private Double Discount;
private Double Invoice_Amt;
private Timestamp Bill_Date;
private int Bill_By;
private int Invoice_No;
//private Boolean IsUsed;
private Boolean IsEditable;
private Timestamp Invoice_Date;
private int Invoice_By;
private int status;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @return the Bill_No
     */
    public int getBill_No() {
        return Bill_No;
    }

    /**
     * @param Bill_No the Bill_No to set
     */
    public void setBill_No(int Bill_No) {
        this.Bill_No = Bill_No;
    }

    /**
     * @return the Bill_Name
     */
    public String getBill_Name() {
        return Bill_Name;
    }

    /**
     * @param Bill_Name the Bill_Name to set
     */
    public void setBill_Name(String Bill_Name) {
        this.Bill_Name = Bill_Name;
    }

    /**
     * @return the Reading_Value
     */
    public int getReading_Value() {
        return Reading_Value;
    }

    /**
     * @param Reading_Value the Reading_Value to set
     */
    public void setReading_Value(int Reading_Value) {
        this.Reading_Value = Reading_Value;
    }

    /**
     * @return the Units
     */
    public int getUnits() {
        return Units;
    }

    /**
     * @param Units the Units to set
     */
    public void setUnits(int Units) {
        this.Units = Units;
    }

    /**
     * @return the Reading_Bill
     */
    public Double getReading_Bill() {
        return Reading_Bill;
    }

    /**
     * @param Reading_Bill the Reading_Bill to set
     */
    public void setReading_Bill(Double Reading_Bill) {
        this.Reading_Bill = Reading_Bill;
    }

    /**
     * @return the Fine
     */
    public Double getFine() {
        return Fine;
    }

    /**
     * @param Fine the Fine to set
     */
    public void setFine(Double Fine) {
        this.Fine = Fine;
    }

    /**
     * @return the Discount
     */
    public Double getDiscount() {
        return Discount;
    }

    /**
     * @param Discount the Discount to set
     */
    public void setDiscount(Double Discount) {
        this.Discount = Discount;
    }


    /**
     * @return the Invoice_No
     */
    public int getInvoice_No() {
        return Invoice_No;
    }

    /**
     * @param Invoice_No the Invoice_No to set
     */
    public void setInvoice_No(int Invoice_No) {
        this.Invoice_No = Invoice_No;
    }

    /**
     * @return the IsUsed
     */

    /**
     * @param IsUsed the IsUsed to set
     */

    /**
     * @return the IsEditable
     */
    public Boolean getIsEditable() {
        return IsEditable;
    }

    /**
     * @param IsEditable the IsEditable to set
     */
    public void setIsEditable(Boolean IsEditable) {
        this.IsEditable = IsEditable;
    }

    /**
     * @return the Bill_Date
     */
    public Timestamp getBill_Date() {
        return Bill_Date;
    }

    /**
     * @param Bill_Date the Bill_Date to set
     */
    public void setBill_Date(Timestamp Bill_Date) {
        this.Bill_Date = Bill_Date;
    }

    /**
     * @return the Bill_By
     */
    public int getBill_By() {
        return Bill_By;
    }

    /**
     * @param Bill_By the Bill_By to set
     */
    public void setBill_By(int Bill_By) {
        this.Bill_By = Bill_By;
    }

    /**
     * @return the Invoice_Date
     */
    public Timestamp getInvoice_Date() {
        return Invoice_Date;
    }

    /**
     * @param Invoice_Date the Invoice_Date to set
     */
    public void setInvoice_Date(Timestamp Invoice_Date) {
        this.Invoice_Date = Invoice_Date;
    }

    /**
     * @return the Invoice_By
     */
    public int getInvoice_By() {
        return Invoice_By;
    }

    /**
     * @param Invoice_By the Invoice_By to set
     */
    public void setInvoice_By(int Invoice_By) {
        this.Invoice_By = Invoice_By;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the Invoice_Amt
     */
    public Double getInvoice_Amt() {
        return Invoice_Amt;
    }

    /**
     * @param Invoice_Amt the Invoice_Amt to set
     */
    public void setInvoice_Amt(Double Invoice_Amt) {
        this.Invoice_Amt = Invoice_Amt;
    }


}
