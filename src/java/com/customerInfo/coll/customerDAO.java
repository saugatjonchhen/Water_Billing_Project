package com.customerInfo.coll;

import com.system.connection.*;
import com.info.model.customerInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class customerDAO {

    public customerInfo getIndividualDetails(int cusID) {
        try {
            Connection con = ConnectionString.connectme();
            String qry = "Select Cusid,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,GrandParentFName,GrandParentMName,GrandParentLName,NoOfMembers,DailyConsumption,ApplicantPhoto,LandOwnerPhoto,CitizenshipScanPhoto,ElectricityBillReceipt,NaxaPassCertifiacte,RegisteredDate,RegisteredBy,CitizenShipNumber,East,West,North,South,District,PDistrict,Municipality,PMunicipality,WardNumber,PWardNumber,HouseNumber,PHouseNumber,Street,PStreet,MobileNumber,PMobileNumber,active from customerinfo where Cusid =?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, cusID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                customerInfo m = new customerInfo();
                m.setCusid(rs.getInt("Cusid"));
                m.setApplicantFName(rs.getString("ApplicantFName"));
                m.setApplicantMName(rs.getString("ApplicantMName"));
                m.setApplicantLName(rs.getString("ApplicantLName"));
                m.setParentFName(rs.getString("ParentFName"));
                m.setParentMName(rs.getString("ParentMName"));
                m.setParentLName(rs.getString("ParentLName"));
                m.setGrandParentFName(rs.getString("GrandParentFName"));
                m.setGrandParentMName(rs.getString("GrandParentMName"));
                m.setGrandParentLName(rs.getString("GrandParentLName"));
                m.setNoOfMembers(rs.getInt("NoOfMembers"));
                m.setDailyConsumption(rs.getInt("DailyConsumption"));
                m.setApplicantPhoto(rs.getString("ApplicantPhoto"));
                m.setLandOwnerPhoto(rs.getString("LandOwnerPhoto"));
                m.setCitizenshipScanPhoto(rs.getString("CitizenshipScanPhoto"));
                m.setElectricityBillReceipt(rs.getString("ElectricityBillReceipt"));
                m.setNaxaPassCertifiacte(rs.getString("NaxaPassCertifiacte"));
                m.setRegisteredDate(rs.getDate("RegisteredDate"));
                m.setRegisteredBy(rs.getString("RegisteredBy"));
                m.setCitizenShipNumber(rs.getString("CitizenShipNumber"));
                m.setEast(rs.getString("East"));
                m.setWest(rs.getString("West"));
                m.setNorth(rs.getString("North"));
                m.setSouth(rs.getString("South"));
                m.setDistrict(rs.getString("District"));
                m.setPDistrict(rs.getString("PDistrict"));
                m.setMunicipality(rs.getString("Municipality"));
                m.setPMunicipality(rs.getString("PMunicipality"));
                m.setWardNumber(rs.getString("WardNumber"));
                m.setPWardNumber(rs.getString("PWardNumber"));
                m.setHouseNumber(rs.getString("HouseNumber"));
                m.setPHouseNumber(rs.getString("PHouseNumber"));
                m.setStreet(rs.getString("Street"));
                m.setPStreet(rs.getString("PStreet"));
                m.setMobileNumber(rs.getString("MobileNumber"));
                m.setPMobileNumber(rs.getString("PMobileNumber"));
                m.setActive(rs.getBoolean("active"));
                return m;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("getIndividualDetails error " + e);
        }
        return null;
    }
    public Boolean insertnewCusInfo(customerInfo cusinfo) {
        Boolean retval = false;
        try {
            Connection con = ConnectionString.connectme();
            String qry = "INSERT INTO customerinfo(ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,GrandParentFName,GrandParentMName,GrandParentLName,NoOfMembers,DailyConsumption,ApplicantPhoto,LandOwnerPhoto,CitizenshipScanPhoto,ElectricityBillReceipt,NaxaPassCertifiacte,RegisteredDate,RegisteredBy,CitizenShipNumber,East,West,North,South,District,PDistrict,Municipality,PMunicipality,WardNumber,PWardNumber,HouseNumber,PHouseNumber,Street,PStreet,MobileNumber,PMobileNumber,active) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, cusinfo.getApplicantFName());
            pst.setString(2, cusinfo.getApplicantMName());
            pst.setString(3, cusinfo.getApplicantLName());
            pst.setString(4, cusinfo.getParentFName());
            pst.setString(5, cusinfo.getParentMName());
            pst.setString(6, cusinfo.getParentLName());
            pst.setString(7, cusinfo.getGrandParentFName());
            pst.setString(8, cusinfo.getGrandParentMName());
            pst.setString(9, cusinfo.getGrandParentLName());
            pst.setInt(10, cusinfo.getNoOfMembers());
            pst.setInt(11, cusinfo.getDailyConsumption());
            pst.setString(12, cusinfo.getApplicantPhoto());
            pst.setString(13, cusinfo.getLandOwnerPhoto());
            pst.setString(14, cusinfo.getCitizenshipScanPhoto());
            pst.setString(15, cusinfo.getElectricityBillReceipt());
            pst.setString(16, cusinfo.getNaxaPassCertifiacte());
            pst.setDate(17, (Date) cusinfo.getRegisteredDate());
            pst.setString(18, cusinfo.getRegisteredBy());
            pst.setString(19, cusinfo.getCitizenShipNumber());
            pst.setString(20, cusinfo.getEast());
            pst.setString(21, cusinfo.getWest());
            pst.setString(22, cusinfo.getNorth());
            pst.setString(23, cusinfo.getSouth());
            pst.setString(24, cusinfo.getDistrict());
            pst.setString(25, cusinfo.getPDistrict());
            pst.setString(26, cusinfo.getMunicipality());
            pst.setString(27, cusinfo.getPMunicipality());
            pst.setString(28, cusinfo.getWardNumber());
            pst.setString(29, cusinfo.getPWardNumber());
            pst.setString(30, cusinfo.getHouseNumber());
            pst.setString(31, cusinfo.getPHouseNumber());
            pst.setString(32, cusinfo.getStreet());
            pst.setString(33, cusinfo.getPStreet());
            pst.setString(34, cusinfo.getMobileNumber());
            pst.setString(35, cusinfo.getPMobileNumber());
            pst.setBoolean(36, cusinfo.getActive());
            int executeUpdate = pst.executeUpdate();
            if (executeUpdate >= 1) {
                retval = !retval;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("INSERT INTO customerinfo    " + e);
        }
        return retval;
    }
}
