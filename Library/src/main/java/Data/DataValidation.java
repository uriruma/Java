/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author uriru
 */
public class DataValidation {
    
    public static boolean isValidString(String name){
        if (!name.matches("^[a-zA-Z]*$")) {
            return false;
        } else if (name.indexOf(' ') >= 0){
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean isValidISBN(String isbn) {
        int count = 0;//counter to know how many digits there are
        for (int i = 0; i < isbn.length(); i++) {
            if (Character.isDigit(isbn.charAt(i))) {
                count++;//if there is a character then count sum 1
            }
        }
        return count == 11;//if there are 11 digits then it's a valid isbn
    }
}
