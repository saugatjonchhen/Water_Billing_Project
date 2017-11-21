package com.login.coll;

import com.info.model.staff;
import com.system.connection.ConnectionString;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDAO {
    public staff validUser(staff sstaf){
         try {
            Connection con = ConnectionString.connectme();
            String sql = "select id,staff_id,staff_pwd,staff_first_name,staff_last_name,staff_middle_name,insert_control,edit_control,billing_control,pay_control,isInService,Registered_date,isSuperAdmin from stafflogin where staff_id  =? AND staff_pwd =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sstaf.getStaff_id());
            pst.setString(2, sstaf.getStaff_pwd());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                staff Staf = new staff();
                Staf.setId(rs.getInt("id"));
                Staf.setStaff_id(rs.getString("staff_id"));
                Staf.setStaff_pwd(rs.getString("staff_pwd"));
                Staf.setStaff_first_name(rs.getString("staff_first_name"));
                Staf.setStaff_last_name(rs.getString("staff_last_name"));
                Staf.setStaff_middle_name(rs.getString("staff_middle_name"));
                Staf.setInsert_control(rs.getBoolean("insert_control"));
                Staf.setEdit_control(rs.getBoolean("edit_control"));
                Staf.setBilling_control(rs.getBoolean("billing_control"));
                Staf.setPay_control(rs.getBoolean("pay_control"));
                Staf.setIsInService(rs.getBoolean("isInService"));
                Staf.setRegistered_date(rs.getDate("Registered_date"));
                Staf.setIsSuperAdmin(rs.getBoolean("isSuperAdmin"));
                return Staf;
            }
            con.close();            
        } catch (Exception e) {
            System.out.println("query error" + e);
        }
        return null;
    }
    
    public static staff UserIdToFulStaff_details(String id){
        try {
            Connection con = ConnectionString.connectme();
            String sql = "select id,staff_id,staff_pwd,staff_first_name,staff_last_name,staff_middle_name,insert_control,edit_control,billing_control,pay_control,isInService,Registered_date,isSuperAdmin from stafflogin where staff_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                staff Staf = new staff();
                Staf.setId(rs.getInt("id"));
                Staf.setStaff_id(rs.getString("staff_id"));
                Staf.setStaff_pwd(rs.getString("staff_pwd"));
                Staf.setStaff_first_name(rs.getString("staff_first_name"));
                Staf.setStaff_last_name(rs.getString("staff_last_name"));
                Staf.setStaff_middle_name(rs.getString("staff_middle_name"));
                Staf.setInsert_control(rs.getBoolean("insert_control"));
                Staf.setEdit_control(rs.getBoolean("edit_control"));
                Staf.setBilling_control(rs.getBoolean("billing_control"));
                Staf.setPay_control(rs.getBoolean("pay_control"));
                Staf.setIsInService(rs.getBoolean("isInService"));
                Staf.setRegistered_date(rs.getDate("Registered_date"));
                Staf.setIsSuperAdmin(rs.getBoolean("isSuperAdmin"));
                 return Staf;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("query error" + e);
        }
        return null;
    }
}
