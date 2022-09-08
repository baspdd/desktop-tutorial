/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duypham0705
 */
public class Input {

    public static boolean checkInt(String mess, int min, int max) {
        if (mess.matches("[0-9]+")) {
            int ret = Integer.parseInt(mess);
            if (min <= ret && ret <= max) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDouble(String mess) {
        if (mess.matches("^[0-9]*.[0-9]+$")) {
            return true;
        }
        if (mess.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

}
