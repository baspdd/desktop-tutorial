/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validate;

/**
 *
 * @author duypham0705
 */
public class Input {

    public static boolean checkInt(String mess, int min, int max) {
        if (mess.matches("[0-9]+")) {
            int ret = Integer.parseInt(mess);
            if (min < ret && ret <= max) {
                return true;
            }
        }
        return false;
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
