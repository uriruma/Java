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
public class Vulcanian extends Being {

    protected int meditation;
    protected static final int lvl = 3;

    public Vulcanian() {

    }

    public Vulcanian(int meditation, String name) {
        super(name);
        this.meditation = meditation;
    }

    public int getMeditation() {
        return meditation;
    }

    public void setMeditation(int meditation) {
        this.meditation = meditation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Vulcanian{meditation=").append(meditation);
        sb.append(", lvl=").append(lvl);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {

            return false;

        } else {

            return true;
        }
        /*final Vulcanian other = (Vulcanian) obj;
        if (this.meditation != other.meditation) {
            return false;
        }*/
        //return true;
    }
}
