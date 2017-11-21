package com.superAdmin.col;

import com.info.model.staff;
import com.system.connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class superAdminDAO {

    public staff ValidStaffId(String Staff_id) {
        try {
            Connection con = ConnectionString.connectme();
            String sql = "select id,staff_id,staff_pwd,staff_first_name,staff_last_name,staff_middle_name,insert_control,edit_control,billing_control,pay_control,isInService,Registered_date,isSuperAdmin,Registered_By from stafflogin where staff_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Staff_id);
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
                Staf.setRegistered_By(rs.getString("Registered_By"));
                return Staf;
            }
        } catch (Exception e) {
            System.out.println("ValidStaffId SuperAdminDAO error" + e);
        }
        return null;
    }

    public Boolean UpdateRights(staff staff_updatedDetails) {
        Boolean sucess = false;
        try {
            Connection con = ConnectionString.connectme();
            String sql = "update stafflogin set insert_control=?,edit_control=?,billing_control=?,pay_control=?,isInService=?,isSuperAdmin=? where staff_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setBoolean(1, staff_updatedDetails.getInsert_control());
            pst.setBoolean(2, staff_updatedDetails.getEdit_control());
            pst.setBoolean(3, staff_updatedDetails.getBilling_control());
            pst.setBoolean(4, staff_updatedDetails.getPay_control());
            pst.setBoolean(5, staff_updatedDetails.getIsInService());
            pst.setBoolean(6, staff_updatedDetails.getIsSuperAdmin());
            pst.setString(7, staff_updatedDetails.getStaff_id());
            int executeUpdate = pst.executeUpdate();
            if (executeUpdate >= 1) {
                sucess = !sucess;
            }
            return sucess;
        } catch (Exception e) {
            System.out.println("query error" + e);
        }
        return sucess;
    }

    public Boolean ChangeHistory(String User, staff newDetails) {
        superAdminDAO s = new superAdminDAO();
        staff OldDetails = s.ValidStaffId(newDetails.getStaff_id());
        Boolean retval = false;
        try {
            Connection con = ConnectionString.connectme();
            String qry = "INSERT INTO staffacesscontrolhistory(staff_id,Changed_by,Changed_Date,insert_control_old,insert_control_new,edit_control_old,edit_control_new,billing_control_old,billing_control_new,pay_control_old,pay_control_new,isInService_old,isInService_new,isSuperAdmin_old,isSuperAdmin_new) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, OldDetails.getStaff_id());
            pst.setString(2, User);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new java.util.Date();
            String frmtdDate = dateFormat.format(date);
            pst.setTimestamp(3, java.sql.Timestamp.valueOf(frmtdDate));

            pst.setBoolean(4, OldDetails.getInsert_control());
            pst.setBoolean(5, newDetails.getInsert_control());
            pst.setBoolean(6, OldDetails.getEdit_control());
            pst.setBoolean(7, newDetails.getEdit_control());
            pst.setBoolean(8, OldDetails.getBilling_control());
            pst.setBoolean(9, newDetails.getBilling_control());
            pst.setBoolean(10, OldDetails.getPay_control());
            pst.setBoolean(11, newDetails.getPay_control());
            pst.setBoolean(12, OldDetails.getIsInService());
            pst.setBoolean(13, newDetails.getIsInService());
            pst.setBoolean(14, OldDetails.getIsSuperAdmin());
            pst.setBoolean(15, newDetails.getIsSuperAdmin());

            int executeUpdate = pst.executeUpdate();
            if (executeUpdate >= 1) {
                retval = !retval;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("heeeee    " + e);
        }
        return retval;
    }
    
    public Boolean Insert_NewStaff_Details_Stafflogin(staff New_StaffDetails){
        Boolean isSuccess = false;
        superAdminDAO superAdminDAO = new superAdminDAO();
        try {
            Connection con = ConnectionString.connectme();
            String qry = "INSERT INTO stafflogin(staff_id,staff_pwd,staff_first_name,staff_last_name,staff_middle_name,insert_control,edit_control,billing_control,pay_control,isInService,Registered_date,isSuperAdmin,Registered_By) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, New_StaffDetails.getStaff_id());
            pst.setString(2, New_StaffDetails.getStaff_id());
            pst.setString(3, New_StaffDetails.getStaff_first_name());
            pst.setString(4, New_StaffDetails.getStaff_last_name());
            pst.setString(5, New_StaffDetails.getStaff_middle_name());
            pst.setBoolean(6, New_StaffDetails.getInsert_control());
            pst.setBoolean(7, New_StaffDetails.getEdit_control());
            pst.setBoolean(8, New_StaffDetails.getBilling_control());
            pst.setBoolean(9, New_StaffDetails.getPay_control());
            pst.setBoolean(10, New_StaffDetails.getIsInService());
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new java.util.Date();
            String frmtdDate = dateFormat.format(date);
            pst.setTimestamp(11, java.sql.Timestamp.valueOf(frmtdDate));
            pst.setBoolean(12, New_StaffDetails.getIsSuperAdmin());
            pst.setString(13, New_StaffDetails.getRegistered_By());
            
            int executeUpdate = pst.executeUpdate();
            if (executeUpdate >= 1) {
                isSuccess = !isSuccess;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Insert_NewStaff_Details_Stafflogin   SuperAdmin DAO " + e);
        }
        
        // insertion success if isSucu = true
        int LastRowId = superAdminDAO.LastRow_Inserted4_newstaff_Details();
        
        if(isSuccess){
            isSuccess = superAdminDAO.CreateTable_4m_staffId(LastRowId);
            if(!isSuccess){
                isSuccess =superAdminDAO.DeleteLast_RowInserted_NewStaffDetails(LastRowId);
            }
        }
        return isSuccess;
    }
    
    public int LastRow_Inserted4_newstaff_Details() {
        int temp = 0;
        try {    //geta autoincrement value
            String viewStudentsQuery = "SELECT MAX(id) as ID FROM stafflogin";
            Connection conn = ConnectionString.connectme();
            PreparedStatement stmt = conn.prepareStatement(viewStudentsQuery);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                temp = rs.getInt("ID");
                return temp;
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("LastRow_Inserted4_newstaff_Details superAdmin " + e);
        }
        return 0;
    }
    
    public Boolean DeleteLast_RowInserted_NewStaffDetails(int LastID){
        Boolean isSuccess = false;
        try {
            Connection con22 = ConnectionString.connectme();
            String qry22 = "DELETE FROM stafflogin WHERE id =?";
            PreparedStatement pst22 = con22.prepareStatement(qry22);
            pst22.setInt(1, LastID);
            int executeUpdate = pst22.executeUpdate();
            if (executeUpdate >= 1) {
                isSuccess = !isSuccess;
            }
            con22.close();
        } catch (Exception e1) {
            System.out.println(" DeleteLast_RowInserted_NewStaffDetails SuperAdminDAO");
        }
        return isSuccess;
    }
    
    public Boolean CreateTable_4m_staffId(int StaffId) {
        Boolean retval = false;
        try {
            String query = "CREATE TABLE ";
            query = query.concat(String.valueOf(StaffId)).concat("ss");
            query = query.concat(" (id int(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,  BillNo varchar(15) NOT NULL,  CustomerID int(11) NOT NULL,  Units int(11) NOT NULL,  Bill_created date NOT NULL,Reading_bill double NOT NULL)");
            Connection conn2 = ConnectionString.connectme();
            PreparedStatement stmt1 = conn2.prepareStatement(query);
            int executeUpdate = stmt1.executeUpdate();
            if (executeUpdate == 0) {
                retval = !retval;
            }
            conn2.close();
        }catch (SQLException e) {
                System.out.println("CreateTable_CustomerId " + e);
        }
        return retval;
    }

}
