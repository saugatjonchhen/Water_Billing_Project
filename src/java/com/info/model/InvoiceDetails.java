package com.info.model;

import java.sql.Timestamp;

public class InvoiceDetails {
    private int Id;
    private int Invoice_No;
    private Double Bill_amt;
    private Double Recieved_Amt;
    private Double balance;
    private Timestamp Invoice_date;
    private int Invoice_By;
    private Boolean isUsed;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
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
     * @return the Bill_amt
     */
    public Double getBill_amt() {
        return Bill_amt;
    }

    /**
     * @param Bill_amt the Bill_amt to set
     */
    public void setBill_amt(Double Bill_amt) {
        this.Bill_amt = Bill_amt;
    }

    /**
     * @return the Recieved_Amt
     */
    public Double getRecieved_Amt() {
        return Recieved_Amt;
    }

    /**
     * @param Recieved_Amt the Recieved_Amt to set
     */
    public void setRecieved_Amt(Double Recieved_Amt) {
        this.Recieved_Amt = Recieved_Amt;
    }

    /**
     * @return the balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * @return the Invoice_date
     */
    public Timestamp getInvoice_date() {
        return Invoice_date;
    }

    /**
     * @param Invoice_date the Invoice_date to set
     */
    public void setInvoice_date(Timestamp Invoice_date) {
        this.Invoice_date = Invoice_date;
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
     * @return the isUsed
     */
    public Boolean getIsUsed() {
        return isUsed;
    }

    /**
     * @param isUsed the isUsed to set
     */
    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }
}
