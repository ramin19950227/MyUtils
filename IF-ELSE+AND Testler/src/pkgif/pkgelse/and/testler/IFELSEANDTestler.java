/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgif.pkgelse.and.testler;

/**
 *
 * @author Ramin
 */
public class IFELSEANDTestler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Test 5:
        int a = 11;
        int b = 10;
        int c = a + b;

        if (a > b && a > c) {
            System.out.println("IF One is True");
        } else {
            System.out.println("IF One is False");
        }

        if (c == a + b) {
            System.out.println("IF Two is True");
        } else {
            System.out.println("IF Two is False");
        }

        //Test 6:
        //bax BU teze ola biler senin ucun
        int s = 3;

        if (s == 1) {
            System.out.println("variable s is 1");
        } else if (s == 2) {
            System.out.println("variable s is 2");
        } else if (s == 3) {
            System.out.println("variable s is 3");
        } else {
            System.out.println("hec biri olmadi");
        }

        //Test 7:
        //bax BU teze ola biler senin ucun
        int d = 4;

        if (d == 1) {
            System.out.println("variable s is 1");
        } else if (d == 2) {
            System.out.println("variable s is 2");
        } else if (d == 3) {
            System.out.println("variable s is 3");
        } else {
            System.out.println("hec biri olmadi");
        }

        //Test 8:
        int aa = 10;
        int bb = aa;
        bb++;
        bb++;
        if (aa == 10 && bb == 10) {
            System.out.println("aa is 10 and bb is 10");
        } else {
            System.out.println("if ONE - is FALSE");
        }

        if (aa == 10 && bb == 11) {
            System.out.println("aa is 10 and bb is 11");
        } else {
            System.out.println("if TWO - is FALSE");
        }

        if (aa == 10 && bb == 12) {
            System.out.println("aa is 10 AND bb is 12");
        } else {
            System.out.println("if THREE - is FALSE");
        }

        //Test 9:
        int ff = 10;
        if (ff != 10) {
            System.out.println("variable ff is NOT 10");
        } else {
            System.out.println("variable ff is 10");
        }

    }

}
