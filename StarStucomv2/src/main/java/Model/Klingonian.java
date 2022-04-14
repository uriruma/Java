/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author uriru
 */
public class Klingonian extends Being {

    protected int strength;
    protected static final int lvl = 3;

    public Klingonian(int strength, String name) {
        super(name);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Klingonian{strength=").append(strength);
        sb.append(", lvl=").append(lvl);
        sb.append('}');
        return sb.toString();
    }

}
