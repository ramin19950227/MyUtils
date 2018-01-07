/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accestest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ramin
 */
public class TestSelect {
    //DESC - birinci en axirincini qoy. yani 1,2,3,4,5,6,7,8,9,10 idise id-si 
    //DESC-  bize 10,9,8,7,6,5,4,3,2,1 verecek ve ilk setirde hemishe son id-miz olacaq

    public static void main(String[] ramin) throws ClassNotFoundException, SQLException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Test.accdb");
        Statement s = conn.createStatement();

        ResultSet rs = s.executeQuery("select * from user order by ID DESC LIMIT 1");
        if (rs.next()) {
            System.err.println(rs.getString(1));
        }
    }

}
