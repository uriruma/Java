package Controller;

import static Controller.PlanetController.getPlanetByName;
import static Controller.PlanetController.getPlanets;
import static MyLibrary.Data.*;
import Model.*;
import static Model.Andorian.typeOfRank;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author uriru
 */
public class BeingController {

    //este array es el general para todos los seres vivos registrados, independiente del planeta
    private static ArrayList<Being> generalPopulation = new ArrayList<>();

    //obtener todos los seres en general
    public static ArrayList<Being> getAllBeings() {
        return generalPopulation;
    }

    //obtener un ser a traves del nombre
    public static Being getBeingByName(String name) {
        boolean find = false;
        int pos = 0;
        for (int i = 0; i < generalPopulation.size() && !find; i++) {
            if (generalPopulation.get(i).getName().equals(name)) {
                find = true;
                pos = i;
            }
        }
        Being b = generalPopulation.get(pos);
        return b;

    }

    //tipo de ser mediante un entero
    public static int typeOfBeing() {
        System.out.println("[1] - Human ");
        System.out.println("[2] - Vulcanian");
        System.out.println("[3] - Andorian");
        System.out.println("[4] - Nibirian");
        System.out.println("[5] - Klingon");
        System.out.println("[6] - Ferenginian");
        int type = inputBetween(1, 6);
        if (type < 1 && type > 6) {
            typeOfBeing();
        }
        return type;
    }

    //registrar ser
    public static void newBeing() {
        System.out.println("Creating a living being.");
        Being b = new Being();

        System.out.println("Introduce a name:");
        String name = readValidString();

        if (!generalPopulation.contains(new Being(name))) {//si el ser no esta repetido
            System.out.println("What breed is the living being?");
            int type = typeOfBeing();

            switch (type) {//dependiendo del tipo de ser pedimos sus distintas propiedades propias
                case 1:
                    System.out.println("Human");
                    System.out.println("What age " + name + " has?");
                    int age = inputBetween(0, 130);
                    System.out.println("What gender has?");
                    boolean gender = booleanBetween2("male", "female");
                    //Human h = (new Human(age, gender, name));
                    b = new Human(age, gender, name);
                    break;

                case 2:
                    System.out.println("Vulcanian");
                    System.out.println("What value of meditation it has?");
                    int meditation = inputBetween(0, 10);
                    //Vulcanian v = (new Vulcanian(meditation, name));
                    b = new Vulcanian(meditation, name);
                    break;

                case 3:
                    System.out.println("Andorian");
                    System.out.println("What rank does it have?");
                    int rank = typeOfRank();
                    System.out.println("Is it aenar?");
                    boolean aenar = whatBooleanIs("aenar");
                    //Andorian a = (new Andorian(rank, aenar, name));
                    b = new Andorian(rank, aenar, name);
                    break;

                case 4:
                    System.out.println("Nibirian");
                    System.out.println("What is it's feeding?");
                    boolean feeding = booleanBetween2("red fluorine", "fish");
                    //Nibirian n = (new Nibirian(feeding, name));
                    b = new Nibirian(feeding, name);
                    break;

                case 5:
                    System.out.println("Klingonian");
                    System.out.println("How many strength does it has?");
                    int strength = inputBetween(50, 350);
                    //Klingonian k = (new Klingonian(strength, name));
                    b = new Klingonian(strength, name);
                    break;

                case 6:
                    System.out.println("Ferenganian");
                    System.out.println("How many latinum does it has?");
                    int latinum = readNumberHigherThan(0);
                    //Ferenganian f = (new Ferenganian (latinum, name));
                    b = new Ferenganian(latinum, name);
                    break;
            }
            if (beingPlanetAvailable(b)) {//aqui mostramos los planetas disponibles que hay para el ser creado anteriormente
                System.out.println("Which planet does the being will live?");//nos devuelve false si no hay ninguno disponible
                String planetName = readValidString();

                if (getPlanets().contains(new Planet(planetName))) {//buscamos si contiene el planeta con el nombre pedido
                    Planet planet = getPlanetByName(planetName);//nos devuelve el planeta a traves del nombre
                    generalPopulation.add(b);//añadimos el ser al array de seres generales
                    planet.getPopulation().add(b);//añadimos el ser a la poblacion del planeta correspondiendte
                    planet.viewPopulation();//mostramos los seres del planeta 
                } else {
                    System.out.println("This planet doesn't exist.");
                    b = null;//si el planeta no existe borramos el ser
                }
            } else {
                System.out.println("There aren't any available planets for this being :(");
                b = null;//si no hay ningun planeta disponible borramos el ser
            }
        } else {
            System.out.println("This being already exists");
        }

    }

    //eliminar un ser
    public static void deleteBeing() {
        if (!generalPopulation.isEmpty()) {
            viewAllBeings();//mostramos todos los seres
            System.out.println("What being do you want to delete?");
            String name = readValidString();

            if (generalPopulation.contains(new Being(name))) {//miramos si el ser existe en el array general
                Being b = getBeingByName(name);//si existe nos devuelve el ser que queremos eliminar
                generalPopulation.remove(b);//eliminar del array general
                for (Planet p : getPlanets()) {//eliminar del array del planeta que contenga este ser
                    if (p.getPopulation().contains(b)) {
                        p.getPopulation().remove(b);
                    }
                }
                System.out.println("It has been deleted.");
            } else {
                System.out.println("This being doesn't exist.");
            }
        } else {
            System.out.println("There isn't any being");
        }

    }

    //ver todos los seres
    public static void viewAllBeings() {
        for (Being b : generalPopulation) {
            System.out.println(b);
        }
    }

    //mostrar seres a traves del tipo
    public static void viewBeings() {
        if (!generalPopulation.isEmpty()) {
            System.out.println("What type of being do you want to see?");
            int type = typeOfBeing();//pedimos el tipo de ser que quiera ver
            for (Being b : generalPopulation) {//recorremos todo el array
                switch (type) {//dependiendo del tipo que hayamos dicho que nos muestre o no los seres
                    case 1:
                        if (b instanceof Human) {
                            System.out.println(b);
                        }
                        break;
                    case 2:
                        if (b instanceof Vulcanian) {
                            System.out.println(b);
                        }
                        break;
                    case 3:
                        if (b instanceof Andorian) {
                            System.out.println(b);
                        }
                        break;
                    case 4:
                        if (b instanceof Nibirian) {
                            System.out.println(b);
                        }
                        break;
                    case 5:
                        if (b instanceof Klingonian) {
                            System.out.println(b);
                        }
                        break;
                    case 6:
                        if (b instanceof Ferenganian) {
                            System.out.println(b);
                        }
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.println("There isn't any being!");
        }
    }

    //beingPlanetAvailable(): dependiendo de que especie pertenezca el ser que le pasamos como parametro,
    //que recorra los planetas del array solo en el caso que se cumpla los requisitos para vivir
    public static boolean beingPlanetAvailable(Being b) {
        boolean available = false;//en el caso que no se muestre ningun planeta, available seguira como false
        if (b instanceof Human) {
            if (getPlanets().isEmpty()) {
                System.out.println("You have to create a planet first!");
            } else {
                available = true;
                System.out.println("*** Planets ***");
                for (Planet p : getPlanets()) {
                    System.out.println(p);
                }
            }

        } else if (b instanceof Vulcanian) {
            if (getPlanets().isEmpty()) {
                System.out.println("You have to create a planet first!");
            } else {
                System.out.println("*** Planets ***");
                for (Planet p : getPlanets()) {
                    if (!(p.getPopulation().contains(new Andorian()))) {
                        available = true;
                        System.out.println(p);
                    }
                }
            }
        } else if (b instanceof Andorian) {
            if (getPlanets().isEmpty()) {
                System.out.println("You have to create a planet first!");
            } else {
                System.out.println("andorian");
                System.out.println("*** Planets ***");
                for (Planet p : getPlanets()) {
                    if (!(p.getPopulation().contains(new Vulcanian()))) {
                        available = true;
                        System.out.println(p);
                    }
                }
            }
        } else if (b instanceof Nibirian) {
            if (getPlanets().isEmpty()) {
                System.out.println("You have to create a planet first!");
            } else {
                System.out.println("*** Planets ***");
                for (Planet p : getPlanets()) {
                    if (((Nibirian) b).isFeeding() == true && p.isRedFluorine() == true) {
                        available = true;
                        System.out.println(p);
                    }
                    if (((Nibirian) b).isFeeding() == false && p.isAquaticBeings() == true) {
                        available = true;
                        System.out.println(p);
                    }

                }
            }
        } else if (b instanceof Klingonian) {
            if (getPlanets().isEmpty()) {
                System.out.println("You have to create a planet first!");
            } else {
                System.out.println("*** Planets ***");
                for (Planet p : getPlanets()) {
                    if (!(p.getClimate().equalsIgnoreCase("warm"))) {
                        available = true;
                        System.out.println(p);
                    }
                }
            }
        } else if (b instanceof Ferenganian) {
            if (getPlanets().isEmpty()) {
                System.out.println("You have to create a planet first!");
            } else {
                System.out.println("*** Planets ***");
                for (Planet p : getPlanets()) {
                    if (!(p.getClimate().equalsIgnoreCase("cold"))) {
                        System.out.println(p);
                        available = true;
                    }
                }
            }
        }
        return available;
    }

    //modificar ser
    public static void modifyBeing() {
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        viewAllBeings();
        System.out.println("Enter the name of the being you want to modify:");
        String name = readValidString();//pedimos el nombre del ser

        if (generalPopulation.contains(new Being(name))) {//si el array general contiene este ser
            Being b = getBeingByName(name);//cogemos al ser por el nombre introducido ya q si existe

            if (b instanceof Human) {//dependiendo de el tipo de ser que sea, le mostramos las caracteristicas 
                do {                 //específicas que pueda modificar de cada ser en concreto
                    System.out.println("What do you want to modify?");
                    System.out.println("[1] - Age");
                    System.out.println("[2] - Gender");
                    System.out.println("[0] - Exit");
                    switch (input.nextInt()) {
                        case 1:
                            System.out.println("What's the age?");
                            ((Human) b).setAge(inputBetween(0, 130));
                            break;
                        case 2:
                            ((Human) b).setGender(booleanBetween2("male", "female"));
                            break;
                        case 0:
                            exit = true;
                            break;
                        default:
                            System.out.println("Only numbers between 0 and 2");
                    }
                } while (!exit);

            } else if (b instanceof Vulcanian) {
                System.out.println("What value of meditation it has?");
                ((Vulcanian) b).setMeditation(inputBetween(0, 10));

            } else if (b instanceof Andorian) {
                do {
                    System.out.println("What do you want to modify?");
                    System.out.println("[1] - Rank");
                    System.out.println("[2] - It is Aenar?");
                    System.out.println("[0] - Exit");
                    switch (input.nextInt()) {
                        case 1:
                            System.out.println("What rank it is?");
                            //int rank = typeOfRank();
                            ((Andorian) b).setRank(typeOfRank());
                            break;
                        case 2:
                            //boolean aenar = whatBooleanIs("Aenar");
                            ((Andorian) b).setAenar(whatBooleanIs("Aenar"));
                            break;
                        case 0:
                            exit = true;
                            break;
                        default:
                            System.out.println("Only numbers between 0 and 2");
                    }
                } while (!exit);

            } else if (b instanceof Nibirian) {
                System.out.println("What is it's feeding?");
                ((Nibirian) b).setFeeding(booleanBetween2("red fluorine", "fish"));

            } else if (b instanceof Klingonian) {
                System.out.println("What is its strength?");
                ((Klingonian) b).setStrength(inputBetween(50, 350));
            } else if (b instanceof Ferenganian) {
                System.out.println("How many latinum does it has?");
                ((Ferenganian) b).setLatinum(readNumberHigherThan(0));
            }

        } else {
            System.out.println("This being doesn't exist.");
        }
    }
}
