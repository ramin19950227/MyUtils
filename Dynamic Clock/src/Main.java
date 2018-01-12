
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ramin
 */
public class Main {

    public static void main(String[] args) {
        //clockTest();
        clockTest2();

    }

    private static void clockTest() {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Date: " + new Date());
                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();

    }

    private static void clockTest2() {
        while(true){
            System.out.println("Date: "+new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
