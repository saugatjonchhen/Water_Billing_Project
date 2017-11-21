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
public class staff {
 private int id;
 private String staff_id;
 private String Registered_By;
 private String staff_pwd;
 private String staff_first_name;
 private String staff_last_name;
 private String staff_middle_name;
 private Date Registered_date;
 private Boolean insert_control;
 private Boolean edit_control;
 private Boolean billing_control;
 private Boolean pay_control;
 private Boolean isInService;
 private Boolean isSuperAdmin;

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
     * @return the staff_pwd
     */
    public String getStaff_pwd() {
        return staff_pwd;
    }

    /**
     * @param staff_pwd the staff_pwd to set
     */
    public void setStaff_pwd(String staff_pwd) {
        this.staff_pwd = staff_pwd;
    }

    /**
     * @return the staff_first_name
     */
    public String getStaff_first_name() {
        return staff_first_name;
    }

    /**
     * @param staff_first_name the staff_first_name to set
     */
    public void setStaff_first_name(String staff_first_name) {
        this.staff_first_name = staff_first_name;
    }

    /**
     * @return the staff_last_name
     */
    public String getStaff_last_name() {
        return staff_last_name;
    }

    /**
     * @param staff_last_name the staff_last_name to set
     */
    public void setStaff_last_name(String staff_last_name) {
        this.staff_last_name = staff_last_name;
    }

    /**
     * @return the staff_middle_name
     */
    public String getStaff_middle_name() {
        return staff_middle_name;
    }

    /**
     * @param staff_middle_name the staff_middle_name to set
     */
    public void setStaff_middle_name(String staff_middle_name) {
        this.staff_middle_name = staff_middle_name;
    }

    /**
     * @return the Registered_date
     */
    public Date getRegistered_date() {
        return Registered_date;
    }

    /**
     * @param Registered_date the Registered_date to set
     */
    public void setRegistered_date(Date Registered_date) {
        this.Registered_date = Registered_date;
    }

    /**
     * @return the insert_control
     */
    public Boolean getInsert_control() {
        return insert_control;
    }

    /**
     * @param insert_control the insert_control to set
     */
    public void setInsert_control(Boolean insert_control) {
        this.insert_control = insert_control;
    }

    /**
     * @return the edit_control
     */
    public Boolean getEdit_control() {
        return edit_control;
    }

    /**
     * @param edit_control the edit_control to set
     */
    public void setEdit_control(Boolean edit_control) {
        this.edit_control = edit_control;
    }

    /**
     * @return the billing_control
     */
    public Boolean getBilling_control() {
        return billing_control;
    }

    /**
     * @param billing_control the billing_control to set
     */
    public void setBilling_control(Boolean billing_control) {
        this.billing_control = billing_control;
    }

    /**
     * @return the pay_control
     */
    public Boolean getPay_control() {
        return pay_control;
    }

    /**
     * @param pay_control the pay_control to set
     */
    public void setPay_control(Boolean pay_control) {
        this.pay_control = pay_control;
    }

    /**
     * @return the isInService
     */
    public Boolean getIsInService() {
        return isInService;
    }

    /**
     * @param isInService the isInService to set
     */
    public void setIsInService(Boolean isInService) {
        this.isInService = isInService;
    }

    /**
     * @return the isSuperAdmin
     */
    public Boolean getIsSuperAdmin() {
        return isSuperAdmin;
    }

    /**
     * @param isSuperAdmin the isSuperAdmin to set
     */
    public void setIsSuperAdmin(Boolean isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    /**
     * @return the Registered_By
     */
    public String getRegistered_By() {
        return Registered_By;
    }

    /**
     * @param Registered_By the Registered_By to set
     */
    public void setRegistered_By(String Registered_By) {
        this.Registered_By = Registered_By;
    }
}
