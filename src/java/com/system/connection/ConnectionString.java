package com.system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionString {

    public static Connection connectme() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kaka_design_test", "root", "");
            return cn;
        } catch (ClassNotFoundException a) {
            System.out.println("Load Driver  " + a);
        } catch (SQLException a) {
            System.out.println("SQL error " + a);
        }
        return null;
    }
}
