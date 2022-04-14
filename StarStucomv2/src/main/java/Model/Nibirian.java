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
public class Nibirian extends Being {

    protected boolean feeding; //true = red fluorine, false = fish;
    protected static final int lvl = 2;

    public Nibirian(boolean feeding, String name) {
        super(name);
        this.feeding = feeding;
    }

    public boolean isFeeding() {
        return feeding;
    }

    public void setFeeding(boolean feeding) {
        this.feeding = feeding;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Nibirian{feeding=").append(feeding);
        sb.append(", lvl=").append(lvl);
        sb.append('}');
        return sb.toString();
    }

}
