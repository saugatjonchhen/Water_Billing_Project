package com.info.model;

import java.util.Date;

public class StaffReadingRecord_Model {
    private int id;
    private String BillNo;
    private int CustomerID;
    private int Units;
    private Date Bill_created;
    private Double Reading_bill;

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
     * @return the BillNo
     */
    public String getBillNo() {
        return BillNo;
    }

    /**
     * @param BillNo the BillNo to set
     */
    public void setBillNo(String BillNo) {
        this.BillNo = BillNo;
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
     * @return the Bill_created
     */
    public Date getBill_created() {
        return Bill_created;
    }

    /**
     * @param Bill_created the Bill_created to set
     */
    public void setBill_created(Date Bill_created) {
        this.Bill_created = Bill_created;
    }

    /**
     * @return the Reading_bill
     */
    public Double getReading_bill() {
        return Reading_bill;
    }

    /**
     * @param Reading_bill the Reading_bill to set
     */
    public void setReading_bill(Double Reading_bill) {
        this.Reading_bill = Reading_bill;
    }
}
