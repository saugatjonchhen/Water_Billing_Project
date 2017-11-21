package com.search;

import com.system.connection.ConnectionString;
import com.info.model.customerInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class searchDAO {

    public List<customerInfo> FirstName_Search(String fname, List<customerInfo> emptylist) {
        try {
            Connection con = ConnectionString.connectme();
            String sql = "select Cusid,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,GrandParentFName,GrandParentMName,GrandParentLName,NoOfMembers,DailyConsumption,ApplicantPhoto,LandOwnerPhoto,CitizenshipScanPhoto,ElectricityBillReceipt,NaxaPassCertifiacte,RegisteredDate,RegisteredBy,CitizenShipNumber,East,West,North,South,District,PDistrict,Municipality,PMunicipality,WardNumber,PWardNumber,HouseNumber,PHouseNumber,Street,PStreet,MobileNumber,PMobileNumber,active from customerinfo where ApplicantFName like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, fname);
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
                emptylist.add(m);
            }
        } catch (Exception e) {
            System.out.println("query error" + e);
        }
        return emptylist;
    }

    public List<customerInfo> MiddleName_Search(String mname, List<customerInfo> list) {
        try {
            Connection con = ConnectionString.connectme();
            String sql = "select Cusid,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,GrandParentFName,GrandParentMName,GrandParentLName,NoOfMembers,DailyConsumption,ApplicantPhoto,LandOwnerPhoto,CitizenshipScanPhoto,ElectricityBillReceipt,NaxaPassCertifiacte,RegisteredDate,RegisteredBy,CitizenShipNumber,East,West,North,South,District,PDistrict,Municipality,PMunicipality,WardNumber,PWardNumber,HouseNumber,PHouseNumber,Street,PStreet,MobileNumber,PMobileNumber,active from customerinfo where ApplicantMName like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,mname);
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
                list.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return list;
    }

    public List<customerInfo> LastName_Search(String sname, List<customerInfo> list) {
        try {
            Connection con = ConnectionString.connectme();
            //String sql = "select RegistrationId,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,RegisteredDate from customerinfo where ApplicantLName like?";
            String sql = "select Cusid,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,GrandParentFName,GrandParentMName,GrandParentLName,NoOfMembers,DailyConsumption,ApplicantPhoto,LandOwnerPhoto,CitizenshipScanPhoto,ElectricityBillReceipt,NaxaPassCertifiacte,RegisteredDate,RegisteredBy,CitizenShipNumber,East,West,North,South,District,PDistrict,Municipality,PMunicipality,WardNumber,PWardNumber,HouseNumber,PHouseNumber,Street,PStreet,MobileNumber,PMobileNumber,active from customerinfo where ApplicantLName like ?";

//            String sql = "select * from customerinfo where ApplicantLName  like?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, sname);
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
                list.add(m);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return list;
    }

    public List<customerInfo> Date_Search(Date Search_date, List<customerInfo> list) {
        try {
            Connection con = ConnectionString.connectme();
            //String sql = "select RegistrationId,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,RegisteredDate from customerinfo where RegisteredDate =?";
            String sql = "select Cusid,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,GrandParentFName,GrandParentMName,GrandParentLName,NoOfMembers,DailyConsumption,ApplicantPhoto,LandOwnerPhoto,CitizenshipScanPhoto,ElectricityBillReceipt,NaxaPassCertifiacte,RegisteredDate,RegisteredBy,CitizenShipNumber,East,West,North,South,District,PDistrict,Municipality,PMunicipality,WardNumber,PWardNumber,HouseNumber,PHouseNumber,Street,PStreet,MobileNumber,PMobileNumber,active from customerinfo where RegisteredDate =?";
            //            String sql = "select * from customerinfo where Registered_date =?";
            PreparedStatement pst = con.prepareStatement(sql);
            java.sql.Date sqlStartDate = new java.sql.Date(Search_date.getTime());
            pst.setDate(1, sqlStartDate);
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
                list.add(m);
            }
            return list;
        } catch (Exception e) {
            System.out.println("err" + e);
        }
        return list;
    }

    public List<customerInfo> CusID_Search(int CusId, List<customerInfo> list) {
        try {
            Connection con = ConnectionString.connectme();
            String sql = "select Cusid,ApplicantFName,ApplicantMName,ApplicantLName,ParentFName,ParentMName,ParentLName,GrandParentFName,GrandParentMName,GrandParentLName,NoOfMembers,DailyConsumption,ApplicantPhoto,LandOwnerPhoto,CitizenshipScanPhoto,ElectricityBillReceipt,NaxaPassCertifiacte,RegisteredDate,RegisteredBy,CitizenShipNumber,East,West,North,South,District,PDistrict,Municipality,PMunicipality,WardNumber,PWardNumber,HouseNumber,PHouseNumber,Street,PStreet,MobileNumber,PMobileNumber,active from customerinfo where Cusid =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, CusId);
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
                list.add(m);
            }
            return list;
        } catch (Exception e) {
            System.out.println("dfasd" + e);
        }
        return list;
    }
}