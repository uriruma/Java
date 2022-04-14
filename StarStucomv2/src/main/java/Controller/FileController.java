/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static Controller.BeingController.*;
import static Controller.PlanetController.*;
import Model.*;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author uriru
 */
public class FileController {

    //para los planetas simplemente se recoge las caracteristicas de los distintos planetas de arrayPlanets y los escribes
    //en el archivo de texto, a partir de la linea 6 se escriben los nombres de los seres pertenecientes al planeta
    public static void writePlanetFile() {
        try {
            File file = new File("Planets.txt");
            if (!file.exists()) {
                System.out.println("Creating Planets.txt");
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileWriter newFile = new FileWriter(file, false);
                for (Planet p : getPlanets()) {
                    newFile.write(p.getPlanetName() + "\t\t" + p.getGalaxy() + "\t\t"
                            + p.getCapacity() + "\t\t" + p.getClimate() + "\t\t"
                            + p.isRedFluorine() + "\t\t" + p.isAquaticBeings());
                    for (Being b : p.getPopulation()) {
                        newFile.write("\t\t" + b.getName());
                    }
                    newFile.write("\n");
                }
                newFile.close();
            } else {
                System.out.println("Couldn't acces to Planets.txt");
            }
        } catch (IOException ex) {
            System.out.println("Unable to save/write Planets.txt");
        }
    }

    //para los seres recogemos las caracteristicas del array General de seres y los escribimos, dependiendo de que tipo de ser
    //sea, escribiremos las propiedades unicas de cada ser, usando el instaceof en cada posicion del array
    //LO DISTINTO es que al principio escribo un entero para indicar que tipo de ser es en el fichero, para el read mas adelante
    public static void writeBeingFile() {
        try {
            File file = new File("Beings.txt");
            if (!file.exists()) {
                System.out.println("Creating Beings.txt");
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileWriter newFile = new FileWriter(file, false);
                for (Being b : getAllBeings()) {
                    if (b instanceof Human) {
                        newFile.write(1 + "\t\t" + ((Human) b).getAge() + "\t\t" + ((Human) b).isGender() + "\t\t"
                                + b.getName());
                    } else if (b instanceof Vulcanian) {
                        newFile.write(2 + "\t\t" + ((Vulcanian) b).getMeditation() + "\t\t" + b.getName());
                    } else if (b instanceof Andorian) {
                        newFile.write(3 + "\t\t" + ((Andorian) b).getRank() + "\t\t" + ((Andorian) b).isAenar() + "\t\t"
                                + b.getName());
                    } else if (b instanceof Nibirian) {
                        newFile.write(4 + "\t\t" + ((Nibirian) b).isFeeding() + "\t\t" + b.getName());
                    } else if (b instanceof Klingonian) {
                        newFile.write(5 + "\t\t" + ((Klingonian) b).getStrength() + "\t\t" + b.getName());

                    } else if (b instanceof Ferenganian) {
                        newFile.write(6 + "\t\t" + ((Ferenganian) b).getLatinum() + "\t\t" + b.getName());
                    }
                    newFile.write("\n");
                }
                newFile.close();
            } else {
                System.out.println("Couldn't acces to Beings.txt");
            }

        } catch (IOException ex) {
            System.out.println("Unable to write/save Beings.txt");
        }
    }

    //simplemente lee las linias del fichero planetas y añade la informacion en el array de planetas
    public static void readPlanetFile() {
        try {
            File file = new File("Planets.txt");
            if (!file.exists()) {
                System.out.println("Couldn't read Planets.txt. File doesn't exists.");
            } else {
                if (file.canRead()) {
                    FileReader newFile = new FileReader(file);
                    BufferedReader newFile2 = new BufferedReader(newFile);

                    String line;
                    while ((line = newFile2.readLine()) != null) {
                        String[] planetData = line.split("\t\t");
                        getPlanets().add(new Planet(planetData[0], planetData[1],
                                Integer.parseInt(planetData[2]), planetData[3],
                                Boolean.parseBoolean(planetData[4]), Boolean.parseBoolean(planetData[5])));
                    }
                    newFile.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Unable to load Planets.txt");
        }
    }

    //lo mismo que en readPlanetFile(), con la diferencia que al principio de todo leemos el entero que nos dice que tipo de ser
    //es, y en dependiendo de cada uno, se lee las distintas propiedades unicas de cada ser y las añadimos
    public static void readBeingFile() {
        try {
            File file = new File("Beings.txt");
            if (!file.exists()) {
                System.out.println("Couldn't read Beings.txt. File doesn't exists.");
            } else {
                if (file.canRead()) {
                    FileReader newFile = new FileReader(file);
                    BufferedReader newFile2 = new BufferedReader(newFile);

                    String line;
                    while ((line = newFile2.readLine()) != null) {
                        String[] beingData = line.split("\t\t");
                        switch (Integer.parseInt(beingData[0])) {
                            case 1:
                                getAllBeings().add(new Human(Integer.parseInt(beingData[1]), Boolean.parseBoolean(beingData[2]), beingData[3]));
                                break;
                            case 2:
                                getAllBeings().add(new Vulcanian(Integer.parseInt(beingData[1]), beingData[2]));
                                break;
                            case 3:
                                getAllBeings().add(new Andorian(Integer.parseInt(beingData[1]), Boolean.parseBoolean(beingData[2]), beingData[3]));
                                break;
                            case 4:
                                getAllBeings().add(new Nibirian(Boolean.parseBoolean(beingData[1]), beingData[2]));
                                break;
                            case 5:
                                getAllBeings().add(new Klingonian(Integer.parseInt(beingData[1]), beingData[2]));
                                break;
                            case 6:
                                getAllBeings().add(new Ferenganian(Integer.parseInt(beingData[1]), beingData[2]));
                                break;
                            default:
                                break;
                        }
                    }
                    newFile.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Unable to load Beings.txt");
        }

    }

    //los seres se registran a partir de la liniea 6 asi que mediante otro bucle for, cogemos los seres correspondientes
    //de los planetas a traves del nombre y los añadimos
    public static void addBeingsToPlanets() {
        try {
            File file = new File("Planets.txt");
            if (!file.exists()) {
                System.out.println("Couldn't add beings to planets");
            } else {
                if (file.canRead()) {
                    FileReader newFile = new FileReader(file);
                    BufferedReader newFile2 = new BufferedReader(newFile);
                    String line;
                    while ((line = newFile2.readLine()) != null) {
                        String[] planetData = line.split("\t\t");
                        Planet p = getPlanetByName(planetData[0]);
                        for (int i = 6; i < planetData.length; i++) {
                            Being b = getBeingByName(planetData[i]);
                            p.getPopulation().add(b);
                        }
                    }
                    newFile.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Couldn't add");
        }
    }
}
