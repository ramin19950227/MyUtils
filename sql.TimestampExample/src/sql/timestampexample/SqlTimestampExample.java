/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.timestampexample;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Ramin
 */
public class SqlTimestampExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date date = new Date();
        
        long l = date.getTime();
        
        Timestamp timestamp = new Timestamp(l);

        System.out.println("util.Date(): " + date);
        System.out.println("long: " + l);
        System.out.println("TimeStamp(): " + new Timestamp(new Date().getTime()));
    }

}
