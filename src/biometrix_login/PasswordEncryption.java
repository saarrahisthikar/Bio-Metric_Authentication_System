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

        String[] array = {"1*", "4f", "x1", "@#", "Zi", "$b", "j9", "%Y", ":/", "g&", "<k", ".P", "?^", ",o", "+_", "-;",
            "Q*", ")0", "]i", "@}", "Z=", "8-", "yC", "!>", "&n", "tD", "~l", "g$", "oE", "*_", "|r", "ma"};

        int remainder = val.length() % 5;

        while (remainder != 0) {
            val = val + "1";
            remainder = remainder - 1;
        }

        ArrayList<String> x = new ArrayList<String>();

        for (int i = 0; i < val.length() - 6; i = i + 5) {
            String binVal = val.substring(i, i + 5);
            String result = getResult(binVal, array);

            x.add(result);
        }

        Collections.reverse(x);

        String password = "";
        for (int i = 0; i < x.size(); i++) {
            password = password + x.get(i);
        }
        return password;
    }

    private static String getResult(String binVal, String[] array) {

        String val;
        switch (binVal) {

            case "00000":
                val = array[0];
                break;
            case "00001":
                val = array[1];
                break;
            case "00010":
                val = array[2];
                break;
            case "00011":
                val = array[3];
                break;
            case "00100":
                val = array[4];
                break;
            case "00101":
                val = array[5];
                break;
            case "00110":
                val = array[6];
                break;
            case "00111":
                val = array[7];
                break;
            case "01000":
                val = array[8];
                break;

            case "01001":
                val = array[9];
                break;
            case "01010":
                val = array[10];
                break;

            case "01011":
                val = array[11];
                break;
            case "01100":
                val = array[12];
                break;
            case "01101":
                val = array[13];
                break;
            case "01110":
                val = array[14];
                break;
            case "01111":
                val = array[15];
                break;
            case "10000":
                val = array[16];
                break;

            case "10001":
                val = array[17];
                break;
            case "10010":
                val = array[18];
                break;
            case "10011":
                val = array[19];
                break;
            case "10100":
                val = array[20];
                break;
            case "10101":
                val = array[21];
                break;
            case "10110":
                val = array[22];
                break;
            case "10111":
                val = array[23];
                break;
            case "11000":
                val = array[24];
                break;

            case "11001":
                val = array[25];
                break;
            case "11010":
                val = array[26];
                break;
            case "11011":
                val = array[27];
                break;
            case "11100":
                val = array[28];
                break;
            case "11101":
                val = array[29];
                break;
            case "11110":
                val = array[30];
                break;
            case "11111":
                val = array[31];
                break;
            default:
                val = "as";

        }
        return val;
    }

}
