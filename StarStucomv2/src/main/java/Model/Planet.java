/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author uriru
 */
public class Planet {

    private String planetName;
    private String galaxy;
    private int capacity;
    private String climate;
    private boolean redFluorine;
    private boolean aquaticBeings;
    private ArrayList<Being> population;//array que contiene los seres vivos pertenecientes al planeta

    public Planet() {
    }

    //construcor per el contains
    public Planet(String name) {
        this.planetName = name;
    }

    public Planet(String planetName, String galaxy, int capacity, String climate, boolean redFluorine, boolean aquaticBeings) {
        this.planetName = planetName;
        this.galaxy = galaxy;
        this.capacity = capacity;
        this.climate = climate;
        this.redFluorine = redFluorine;
        this.aquaticBeings = aquaticBeings;
        population = new ArrayList<>();
        System.out.println(this);
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public boolean isRedFluorine() {
        return redFluorine;
    }

    public void setRedFluorine(boolean redFluorine) {
        this.redFluorine = redFluorine;
    }

    public boolean isAquaticBeings() {
        return aquaticBeings;
    }

    public void setAquaticBeings(boolean aquaticBeings) {
        this.aquaticBeings = aquaticBeings;
    }

    public ArrayList<Being> getPopulation() {
        return population;
    }

    //ver la poblacion del planeta
    public void viewPopulation() {
        for (Being b : population) {
            System.out.println(b);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Planet)) {
            return false;
        }
        final Planet other = (Planet) obj;
        if (!this.planetName.equals(other.planetName)) {
            return false;
        }
        /*if (!Objects.equals(this.planetName, other.planetName)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Planet{name=").append(planetName);
        sb.append(", galaxy=").append(galaxy);
        sb.append(", capacity=").append(capacity);
        sb.append(", climate=").append(climate);
        sb.append(", redFluorine=").append(redFluorine);
        sb.append(", aquaticBeings=").append(aquaticBeings);
        sb.append('}');
        return sb.toString();
    }

}
