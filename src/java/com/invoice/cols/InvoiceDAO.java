package com.invoice.cols;

import com.info.model.BillingDetails;
import com.info.model.InvoiceDetails;
import com.system.connection.ConnectionString;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAO {        
    
    public ArrayList<BillingDetails> SelectBills_NotUsed(int CustomerID){
        try {
            String Query = "SELECT id,Bill_No,Bill_Name,Reading_Bill,Bill_date FROM billing_details where Invoice_Amt=? AND CustomerID=?";
            Connection conn = ConnectionString.connectme();
            PreparedStatement stmt = conn.prepareStatement(Query);
            stmt.setDouble(1, 0);
            stmt.setInt(2, CustomerID);
            ResultSet rs = stmt.executeQuery();
            ArrayList<BillingDetails> List = new ArrayList<BillingDetails>();
            while (rs.next()) {
                BillingDetails BillingDetail = new BillingDetails();
                BillingDetail.setId(rs.getInt("id"));
                BillingDetail.setBill_No(rs.getInt("Bill_No"));
                BillingDetail.setBill_Name(rs.getString("Bill_Name"));
                BillingDetail.setReading_Bill(rs.getDouble("Reading_Bill"));
                BillingDetail.setBill_Date(rs.getTimestamp("Bill_date"));
                BillingDetail.setFine(0.0);
                BillingDetail.setDiscount(0.0);
                BillingDetail.setInvoice_Amt(BillingDetail.getReading_Bill()+BillingDetail.getFine()-BillingDetail.getDiscount());
                List.add(BillingDetail);
                 }
            rs.close();
            conn.close();
             return List;
        } catch (SQLException e) {
            System.out.println("s SelectBills_NotUsed InvoiceDAO " + e);
        }
        return null;
    }
    
    public void InsertRecievedAmt(InvoiceDetails InvoiceDetail){
        
    }
   
}
