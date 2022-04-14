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
public class Ferenganian extends Being {

    protected int latinum;
    protected static final int lvl = 1;

    public Ferenganian(int latinum, String name) {
        super(name);
        this.latinum = latinum;
    }

    public int getLatinum() {
        return latinum;
    }

    public void setLatinum(int latinum) {
        this.latinum = latinum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Ferenganian{latinum=").append(latinum);
        sb.append(", lvl=").append(lvl);
        sb.append('}');
        return sb.toString();
    }

}
