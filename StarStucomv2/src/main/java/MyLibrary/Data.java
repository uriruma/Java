/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibrary;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author uriru
 */
public class Data {
    
    public static int inputBetween(int min, int max) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        do {
            System.out.println("A minimum of " + min + " and a maximum of " + max);
            number = input.nextInt();
        } while (number < min || number > max);

        return number;
    }
    
    public static String readValidString() {
        Scanner input = new Scanner(System.in);
        //creem una expresio regular amb el pattern que contingui només lletres majuscules o minuscules
        Pattern validate = Pattern.compile("^[a-zA-Z]*$");
        
        String firstString = input.nextLine();
        Matcher mat = validate.matcher(firstString);
        //si el previous name coincideix amb el pattern aleshores ens donara true, en cas contrari false
        while (!mat.matches()) {
            System.out.println("Can't contain numbers or special characters, try again!");
            firstString = input.nextLine();
            mat = validate.matcher(firstString);
        }

        System.out.println("Valid!");

        //posar primera lletra en mayus del nom
        String previousFirst = firstString.substring(0, 1);
        String previousLast = firstString.substring(1, firstString.length());
        String first = previousFirst.toUpperCase();
        String last = previousLast.toLowerCase();

        String finalString = first + last;

        return finalString;
    }
    
    public static int readNumberHigherThan(int value) {
        Scanner input = new Scanner(System.in);
        int number = 0;
        do {
            System.out.println("Insert a number higher than " + value);
            number = input.nextInt();
        } while (number <= value);
        return number;
    }
    
    public static boolean whatBooleanIs(String text) {
        Scanner input = new Scanner(System.in);
        System.out.println("Is " + text + "? ( y / n)");
        char option = input.nextLine().charAt(0);

        return option == 'y' || option == 'Y' ? true : false;
    }
   
   public static boolean whatBooleanAre(String text) {
        Scanner input = new Scanner(System.in);
        System.out.println("Are " + text + "? ( y / n)");
        char option = input.nextLine().charAt(0);

        return option == 'y' || option == 'Y' ? true : false;
    }
   
   public static boolean booleanBetween2(String option1, String option2){
       Scanner input = new Scanner(System.in);
       boolean valid = false, result = false;
       do {
           System.out.println("Is: " + option1 + " or " + option2 + "?");
       String option = input.nextLine();
       if (option.equalsIgnoreCase(option1)) {
           result = true;
           valid = true;
       } else if (option.equalsIgnoreCase(option2)) {
           result = false;
           valid = true;
       } else {
           System.out.println("Try again!");
       }
       } while (!valid);
       
       return result;
   }
}
