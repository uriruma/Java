/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static Controller.BeingController.*;
import static Controller.PlanetController.*;
import java.util.Scanner;
import static Controller.FileController.*;

/**
 *
 * @author uriru
 */
public class Main {

    public static void menu() {
        System.out.println("***********STARSTUCOM***********");
        System.out.println("[1] - Registrer a new planet");
        System.out.println("[2] - Create a new being ");
        System.out.println("[3] - Delete a being");
        System.out.println("[4] - View planets");
        System.out.println("[5] - Modify");
        System.out.println("[6] - View beings");
        System.out.println("[0] - Exit");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        //autoAdd();
        readPlanetFile();
        readBeingFile();
        addBeingsToPlanets();
        do {
            menu();
            switch (input.nextInt()) {
                case 1:
                    registerPlanet();
                    writePlanetFile();
                    break;
                case 2:
                    newBeing();
                    writePlanetFile();
                    writeBeingFile();
                    break;
                case 3:
                    deleteBeing();
                    writePlanetFile();
                    writeBeingFile();
                    break;
                case 4:
                    viewPlanetsAndBeings();
                    break;
                case 5:
                    modifyBeing();
                    writePlanetFile();
                    writeBeingFile();
                    break;
                case 6:
                    viewBeings();
                    break;
                case 0:
                    System.out.println("Bye!");
                    exit = true;
                    break;
            }
        } while (!exit);
    }
}
