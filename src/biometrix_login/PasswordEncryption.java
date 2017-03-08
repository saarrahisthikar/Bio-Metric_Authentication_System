/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biometrix_login;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Saarrah_Isthikar
 */
public class PasswordEncryption {

    public static String encryptByte(String strValue) {

        int roundVal = (int) (Math.round(Double.parseDouble(strValue)));
        String value = Integer.toString(roundVal, 2);

        return value;
        //     return newValue;
    }

    private static String getStrValue(char x) {
        String encryptStr = "";

        String[] arr = {"`h?0", "+w4", "dm%", "0p^", "8ot", "@va", "(y^", "5r!", "p0&", "$d_"};

        if (String.valueOf(x).equals("0")) {
            encryptStr = arr[0];
        }
        if (String.valueOf(x).equals("1")) {
            encryptStr = arr[1];
        }
        if (String.valueOf(x).equals("2")) {
            encryptStr = arr[2];
        }
        if (String.valueOf(x).equals("3")) {
            encryptStr = arr[3];
        }
        if (String.valueOf(x).equals("4")) {
            encryptStr = arr[4];
        }
        if (String.valueOf(x).equals("5")) {
            encryptStr = arr[5];
        }
        if (String.valueOf(x).equals("6")) {
            encryptStr = arr[6];
        }
        if (String.valueOf(x).equals("7")) {
            encryptStr = arr[7];
        }
        if (String.valueOf(x).equals("8")) {
            encryptStr = arr[8];
        }
        if (String.valueOf(x).equals("9")) {
            encryptStr = arr[9];
        }
        return encryptStr;
    }

    static String finalPassword(String val) {

        int remainder = val.length() % 5;

        while (remainder != 0) {
            val = val + "1";
            remainder = remainder - 1;
        }

        ArrayList<String> x = new ArrayList<String>();

        for (int i = 0; i < val.length() - 6; i = i + 5) {
            x.add(val.substring(i, i + 5));
        }

        Collections.reverse(x);

        if (x.size() > 2) {

            Collections.swap(x, 0, 3);
        }
        if (x.size() > 5) {

            Collections.swap(x, 4, 6);
        }
        if (x.size() > 10) {

            Collections.swap(x, 8, 11);
        }
        if (x.size() > 20) {

            Collections.swap(x, 7, 21);
        }
        if (x.size() > 7) {

            Collections.swap(x, 2, 8);
        }

        String password = "";
        for (int i = 0; i < x.size(); i++) {
            password = password + x.get(i);
        }
        return password;
    }

}
