/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Support;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author kienb
 */
public class StringHelper {
    public static String printPrice(double price){
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(new Locale("vi","VN"));
        return currencyVN.format(price * Math.pow(10,3));
    }
}
