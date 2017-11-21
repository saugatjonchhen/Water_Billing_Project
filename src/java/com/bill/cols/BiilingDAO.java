package com.bill.cols;

import com.info.model.BillingDetails;
import com.system.connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BiilingDAO {

    public Boolean InsertNewBill(BillingDetails NewEntered_BillingDetails) {
        Boolean retval = false;
        BiilingDAO BiilingDAO = new BiilingDAO();
        try {
            Connection con = ConnectionString.connectme();
            String qry = "INSERT INTO ";
            qry = qry + "billing_details (CustomerID,Bill_No,Bill_Name,Reading_Value,Units,Reading_Bill,Bill_Date,Bill_By,IsEditable,status) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, NewEntered_BillingDetails.getCustomerID());
            pst.setInt(2, BiilingDAO.NextBillNo());
            pst.setString(3, NewEntered_BillingDetails.getBill_Name());
            pst.setInt(4, NewEntered_BillingDetails.getReading_Value());
//            pst.setDate(7, java.sql.Date.valueOf(frmtdDate));
            pst.setInt(5, NewEntered_BillingDetails.getUnits());
            pst.setDouble(6, NewEntered_BillingDetails.getReading_Bill());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new java.util.Date();
            String frmtdDate = dateFormat.format(date);
            pst.setTimestamp(7, java.sql.Timestamp.valueOf(frmtdDate));
            pst.setInt(8, NewEntered_BillingDetails.getBill_By());
//            pst.setBoolean(9, false);
            pst.setBoolean(9, true);
            pst.setInt(10, NewEntered_BillingDetails.getStatus());
            int executeUpdate = pst.executeUpdate();
            if (executeUpdate >= 1) {
                retval = !retval;
            }
            con.close();
            return retval;
        } catch (Exception e) {
            System.out.println("InsertNewBill  BilingDAO" + e);
        }
        return retval;
    }
    
    public int NextBillNo() {
        int temp = 0;
        try {    //geta autoincrement value
            String viewStudentsQuery = "SELECT MAX(Bill_No) as Bill_No FROM billing_details";
            Connection conn = ConnectionString.connectme();
            PreparedStatement stmt = conn.prepareStatement(viewStudentsQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                temp = rs.getInt("Bill_No");
                temp++;
                return temp;
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("NextBillNo BillingDAO " + e);
        }
        return 0;
    }
    
    public String NextMonth_NameGenerator(String Last_BillName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yyyy");
        try {
            Date parse = dateFormat.parse(Last_BillName);
            parse.setMonth(parse.getMonth() + 1);
//            System.out.println(dateFormat.format(parse));
            Last_BillName = (dateFormat.format(parse));
        } catch (Exception e) {
            Last_BillName = " Error Please Contact Support";
        }
        return Last_BillName;
    }
    
    public BillingDetails lastReading_Row(int customerID) {
        try {    //geta autoincrement value
            String viewStudentsQuery = "SELECT id,CustomerID,Bill_Name,Reading_Value from billing_details where CustomerID =? AND Reading_Value=(SELECT MAX(Reading_Value) FROM billing_details WHERE CustomerID=?)";
            Connection conn = ConnectionString.connectme();
            PreparedStatement stmt = conn.prepareStatement(viewStudentsQuery);
            stmt.setInt(1, customerID);
            stmt.setInt(2, customerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BillingDetails BillingDetail = new BillingDetails();
                
//                BillingDetail.setId(rs.getInt("id"));
                BillingDetail.setCustomerID(rs.getInt("CustomerID"));
                BillingDetail.setBill_Name(rs.getString("Bill_Name"));
                BillingDetail.setReading_Value(rs.getInt("Reading_Value"));
                return  BillingDetail;
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("11" + e);
        }
        return null;
    }

    public Double UnitTO_ReadingAmtCalculator(int units) {
        Double final_amt = 0.0;
        if (units <= 5) {
            final_amt = 200.0;
        } else if ((units > 5) && (units <= 9)) {
            Double temp;
            temp = units - 5.0;
            final_amt = 200 + temp * 40.0;
        } else if ((units > 9) && (units <= 13)) {
            Double temp = units - 9.0;
            final_amt = 360 + temp * 60;
        } else {
            Double temp = units - 13.0;
            final_amt = 600 + temp * 100;
        }
//        System.out.println(i+" "+final_amt);
        return final_amt;
    }
}
