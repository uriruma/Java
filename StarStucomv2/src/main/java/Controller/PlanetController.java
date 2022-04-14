/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Being;
import Model.Planet;
import static MyLibrary.Data.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author uriru
 */
public class PlanetController {

    //este array contiene todos los planetas registrados
    private static ArrayList<Planet> arrayPlanets = new ArrayList<>();

    /*public static void autoAdd() {
        //arrayPlanets.add(new Planet(name, galaxy, capacity, climate, redFluorine, aquaticBeings));
        arrayPlanets.add(new Planet("Jupiter", "Lactea", 100, "Warm", true, false));
        arrayPlanets.add(new Planet("Saturn", "Andromeda", 50, "Warm", false, true));
        arrayPlanets.add(new Planet("Earth", "Lactea", 50, "Cold", false, false));
        arrayPlanets.add(new Planet("Pluto", "Bobabibi", 50, "Cold", true, true));
        arrayPlanets.add(new Planet("Nano", "Solarium", 50, "Tempered", false, true));
    }*/
    //obtener el array general de Planetas
    public static ArrayList<Planet> getPlanets() {
        return arrayPlanets;
    }

    //obtener un planeta a traves del nombre
    public static Planet getPlanetByName(String name) {
        boolean find = false;
        int pos = 0;
        for (int i = 0; i < arrayPlanets.size() && !find; i++) {
            if (arrayPlanets.get(i).getPlanetName().equalsIgnoreCase(name)) {
                find = true;
                pos = i;
            }
        }
        Planet p = arrayPlanets.get(pos);
        return p;
    }

    //pedir un tipo de clima a traves de un int y convertirlo en string
    public static String typeOfClimate() {
        Scanner input = new Scanner(System.in);
        String climate = null;
        System.out.println("How is the climate?");
        System.out.println("[1] - Warm");
        System.out.println("[2] - Cold");
        System.out.println("[3] - Tempered");

        switch (input.nextInt()) {
            case 1:
                climate = "Warm";
                break;
            case 2:
                climate = "Cold";
                break;
            case 3:
                climate = "Tempered";
                break;
            default:
                System.out.println("Only option between 1 and 3");
        }

        return climate;

    }

    //registrar planeta
    public static void registerPlanet() {
        System.out.println("Register Planet:");
        System.out.println("Introduce the planet's name:");
        String name = readValidString();//pedimos nombre

        if (!arrayPlanets.contains(new Planet(name))) {//miramos que no exista otro planeta con el mismo nombre
            System.out.println("Enter the galaxy which Planet{" + name + "} belongs to.");
            String galaxy = readValidString();//pedimos galaxia

            System.out.println("What's the Planet{" + name + "} total capacity?");
            int capacity = readNumberHigherThan(0);//pedimos capacidad (aunque en este programa no la utilizo para nada)

            String climate = typeOfClimate();//pedimos clima

            boolean redFluorine = whatBooleanIs("red fluorine");//pedimos si hay fluora roja

            boolean aquaticBeings = whatBooleanAre("aquatic beings");//pedimos si hay seres aquaticos

            arrayPlanets.add(new Planet(name, galaxy, capacity, climate, redFluorine, aquaticBeings));//añadimos planeta

        } else {
            System.out.println("This planet already exists.");
        }
    }

    //ver todos los planetas del arrayPlanets
    public static void viewPlanets() {
        if (!arrayPlanets.isEmpty()) {
            System.out.println("*** Planets ***");
            for (Planet p : arrayPlanets) {
                System.out.println(p);
            }
        } else {
            System.out.println("There isn't any planet yet!");
        }
    }

    //ver planetas con su poblacion
    public static void viewPlanetsAndBeings() {
        if (!arrayPlanets.isEmpty()) {
            System.out.println("*** Planets ***");
            for (Planet p : getPlanets()) {//primero recorremos los planetas
                System.out.println(p);
                if (!p.getPopulation().isEmpty()) {//si hay poblacion la mostramos con otro bucle
                    System.out.println("Population:");
                    for (Being b : p.getPopulation()) {
                        System.out.println(b);
                    }
                } else {
                    System.out.println("No population.");
                }
            }
        } else {
            System.out.println("There isn't any planet yet!");
        }
    }

}
