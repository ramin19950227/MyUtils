/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Java.String.split;

/**
 * Bu Class-da String Tipinin split() metodunu Test edeceyik bashqa Metodlari da
 * oyrendikce bura elave edecem
 *
 * @author Ramin
 */
public class splitExample1 {
    //DIQQET her java classi ayrica Shift + F6 duymelerinin kombinasiyasi ile ishe salin

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "menim - metnim - nece - gorsenir?";
        String[] stringArray = s.split("\\s\\-\\s+");

        //bu curde ede bilerik
        // bunun adi forEach-dir men buna daha cox ustunluk verirem Massivlerle
        // ishledikde bundan istifade elemek maslehetdir
        for (String string : stringArray) {
            System.err.println(string);
        }

        // for-un bu formasi ilede ishlemek olar amma bunnansa yuxaridaki daha asan oxunur-dur
//        for (int i = 0; i < stringArray.length; i++) {
//            String string = stringArray[i];
//            System.err.println(string);
//        }
    }
}
