/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accestest;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;
import javafx.stage.Stage;

/**
 * Bu Class Məlumat Bazası ilə Əməlyyatlar aparmaq üçün istifadə olunur
 *
 * @author Ramin İsmayılov
 * @since 21.12.2017
 */
public class DBUtil {

    /**
     * Connection Obyetimizi elan edirik irelide istifade edeceyik
     */
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static final String dbType = "access";

    /**
     * Metodun Connection URL-de Melumat Bazasi adi istifade olunmur
     *
     * @throws SQLException
     */
    public static void Connect() throws SQLException {
        if (dbType.equals("mysql")) {
//
//            /**
//             * Driveri bundan evvel her qoshulmada teyin edirdi yada
//             * hazirlayirdi her ne edirdise, amma mene ele gelir bunu her
//             * qoshulmada etmek yersiz ola biler, o sebebden bunu Class-a ilk
//             * muraciet zamani edirik ve 1-defe edirik her defe yox
//             */
//            // MySQL driverini hazirlayiriq teyin edirik
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException ex) {
//            }
//
//            // DBProperties Obyektimizdeki URL ile bazamiza qoshulmaga calishiriq
//            try {
//                // Elde etdyimz Elaqe (Connection) Obyektini conn adli yuxarida elan etdiyimiz unvana yerleshdiririk;
//                conn = DriverManager.getConnection(MyProperties.getDBProperties().getDirectUrl());
//                rs = null;
//                stmt = null;
//
//            } catch (SQLException e) {
//                throw e;
//            }
//            // ve Bitdi. Bize lazim olan bu qeder idi elaqe qurduq ve yerleshdirdik conn adli unvana
//            // ve Obyektimiz artiq istifadeye hazirdir. ishimiz bitirdikden sonra baglamagi unutmayin
//            // ve Bitdi. Bize lazim olan bu qeder idi elaqe qurduq ve yerleshdirdik conn adli unvana
//            // ve Obyektimiz artiq istifadeye hazirdir. ishimiz bitirdikden sonra baglamagi unutmayin

        } else if (dbType.equals("access")) {
            System.out.println("com.salesoft.database.DBUtil.Connect() access");
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                conn = DriverManager.getConnection("jdbc:ucanaccess://Test.accdb");
                rs = null;
                stmt = null;

            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }

    }

//
    /**
     * Metod aciq olan elaqeleri baglayir
     *
     * @throws SQLException
     */
    public static void Disconnect() throws SQLException {
        try {
            if (rs != null) {
                //Close resultSet
                rs.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("SQLException -  DBUtil.allDisconnect(): " + e);
            throw e;
        }
    }

    /**
     * Metod Connection URL-inde yani qoshulma unvaninda DB name Baza adindan
     * istifade etmir
     *
     * @param selectSQLQuery
     * @return
     * @throws SQLException
     */
    public static ResultSet executeQuery(String selectSQLQuery) throws SQLException {
        //old
        //CachedRowSetImpl crs = new CachedRowSetImpl();
        try {
            //Connect to DBProperties (Establish MySQL Connection)
            Connect();
            //System.out.println("selectSQLQuery: " + selectSQLQuery + "\n");

            stmt = conn.createStatement();

            //Execute select (query) operation
            rs = stmt.executeQuery(selectSQLQuery);

            return rs;
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Metodun Connection URL-de Melumat Bazasi adi istifade olunmur, belece
     * CREATE sorgularini rahatliqla ede bilerem
     *
     * @param updateSQLQuery
     * @throws SQLException
     */
    public static void executeUpdate(String updateSQLQuery) throws SQLException {
        if (dbType.equals("mysql")) {
            try {
                //Connect to DBProperties (Establish MySQL Connection)
                Connect();

                //System.out.println("updateSQLQuery :" + updateSQLQuery);
                //Create Statement
                stmt = conn.createStatement();
                //Run executeUpdate operation with given sql statement
                stmt.executeUpdate(updateSQLQuery);
            } catch (SQLException e) {
                System.out.println("SQLException -  DBUtil.dbExecuteUpdate(): " + e);
                throw e;
            } finally {
                //Close connection
                Disconnect();
            }
        } else if (dbType.equals("access")) {

        }
    }

    /**
     * Metod Server Ile Elaqe olub olmadigini yoxlayir
     *
     * @return
     */
    public static boolean hasConnetion() {
        if (dbType.equals("mysql")) {
            try {
                Connect();
                Disconnect();
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
        } else if (dbType.equals("access")) {
            try {
                Connect();
                Disconnect();
                return true;
            } catch (SQLException ex) {
                System.out.println(ex);
                return false;
            }
        }
        return false;
    }

    public static Boolean isTableExist(String db, String table) {
        try {
            DBUtil.executeQuery("select * from " + table + " LIMIT 1");
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

}
