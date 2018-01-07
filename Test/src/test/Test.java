/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ramin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Class.forName error");
        }

        Connection conn;

        try {
            conn = DriverManager.getConnection("jdbc:ucanaccess://test.accdb;jackcessOpener=test.CryptCodecOpener", "hamreen", "12345");
            System.out.println("succes");

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from user");

            System.out.println(rs.next());
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
