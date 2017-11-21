/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.model;

import java.util.Date;

/**
 *
 * @author Saroj
 */
public class StaffAccessControl_Model {
    private int id;
    private String staff_id;
    private String Changed_by;
    private Date Changed_Date;
    private Boolean insert_control_old;
    private Boolean insert_control_new;
    private Boolean edit_control_old;
    private Boolean edit_control_new;
    private Boolean billing_control_old;
    private Boolean billing_control_new;
    private Boolean pay_control_old;
    private Boolean pay_control_new;
    private Boolean isInService_old;
    private Boolean isInService_new;
    private Boolean isSuperAdmin_old;
    private Boolean isSuperAdmin_new;   

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
     * @return the staff_id
     */
    public String getStaff_id() {
        return staff_id;
    }

    /**
     * @param staff_id the staff_id to set
     */
    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    /**
     * @return the Changed_by
     */
    public String getChanged_by() {
        return Changed_by;
    }

    /**
     * @param Changed_by the Changed_by to set
     */
    public void setChanged_by(String Changed_by) {
        this.Changed_by = Changed_by;
    }

    /**
     * @return the Changed_Date
     */
    public Date getChanged_Date() {
        return Changed_Date;
    }

    /**
     * @param Changed_Date the Changed_Date to set
     */
    public void setChanged_Date(Date Changed_Date) {
        this.Changed_Date = Changed_Date;
    }

    /**
     * @return the insert_control_old
     */
    public Boolean getInsert_control_old() {
        return insert_control_old;
    }

    /**
     * @param insert_control_old the insert_control_old to set
     */
    public void setInsert_control_old(Boolean insert_control_old) {
        this.insert_control_old = insert_control_old;
    }

    /**
     * @return the insert_control_new
     */
    public Boolean getInsert_control_new() {
        return insert_control_new;
    }

    /**
     * @param insert_control_new the insert_control_new to set
     */
    public void setInsert_control_new(Boolean insert_control_new) {
        this.insert_control_new = insert_control_new;
    }

    /**
     * @return the edit_control_old
     */
    public Boolean getEdit_control_old() {
        return edit_control_old;
    }

    /**
     * @param edit_control_old the edit_control_old to set
     */
    public void setEdit_control_old(Boolean edit_control_old) {
        this.edit_control_old = edit_control_old;
    }

    /**
     * @return the edit_control_new
     */
    public Boolean getEdit_control_new() {
        return edit_control_new;
    }

    /**
     * @param edit_control_new the edit_control_new to set
     */
    public void setEdit_control_new(Boolean edit_control_new) {
        this.edit_control_new = edit_control_new;
    }

    /**
     * @return the billing_control_old
     */
    public Boolean getBilling_control_old() {
        return billing_control_old;
    }

    /**
     * @param billing_control_old the billing_control_old to set
     */
    public void setBilling_control_old(Boolean billing_control_old) {
        this.billing_control_old = billing_control_old;
    }

    /**
     * @return the billing_control_new
     */
    public Boolean getBilling_control_new() {
        return billing_control_new;
    }

    /**
     * @param billing_control_new the billing_control_new to set
     */
    public void setBilling_control_new(Boolean billing_control_new) {
        this.billing_control_new = billing_control_new;
    }

    /**
     * @return the pay_control_old
     */
    public Boolean getPay_control_old() {
        return pay_control_old;
    }

    /**
     * @param pay_control_old the pay_control_old to set
     */
    public void setPay_control_old(Boolean pay_control_old) {
        this.pay_control_old = pay_control_old;
    }

    /**
     * @return the pay_control_new
     */
    public Boolean getPay_control_new() {
        return pay_control_new;
    }

    /**
     * @param pay_control_new the pay_control_new to set
     */
    public void setPay_control_new(Boolean pay_control_new) {
        this.pay_control_new = pay_control_new;
    }

    /**
     * @return the isInService_old
     */
    public Boolean getIsInService_old() {
        return isInService_old;
    }

    /**
     * @param isInService_old the isInService_old to set
     */
    public void setIsInService_old(Boolean isInService_old) {
        this.isInService_old = isInService_old;
    }

    /**
     * @return the isInService_new
     */
    public Boolean getIsInService_new() {
        return isInService_new;
    }

    /**
     * @param isInService_new the isInService_new to set
     */
    public void setIsInService_new(Boolean isInService_new) {
        this.isInService_new = isInService_new;
    }

    /**
     * @return the isSuperAdmin_old
     */
    public Boolean getIsSuperAdmin_old() {
        return isSuperAdmin_old;
    }

    /**
     * @param isSuperAdmin_old the isSuperAdmin_old to set
     */
    public void setIsSuperAdmin_old(Boolean isSuperAdmin_old) {
        this.isSuperAdmin_old = isSuperAdmin_old;
    }

    /**
     * @return the isSuperAdmin_new
     */
    public Boolean getIsSuperAdmin_new() {
        return isSuperAdmin_new;
    }

    /**
     * @param isSuperAdmin_new the isSuperAdmin_new to set
     */
    public void setIsSuperAdmin_new(Boolean isSuperAdmin_new) {
        this.isSuperAdmin_new = isSuperAdmin_new;
    }
}
