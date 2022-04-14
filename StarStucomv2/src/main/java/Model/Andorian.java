/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author uriru
 */
public class Andorian extends Being {

    protected int rank;
    protected boolean aenar;
    protected static final int lvl = 2;

    public Andorian() {
    }

    public Andorian(int rank, boolean aenar, String name) {
        super(name);
        this.rank = rank;
        this.aenar = aenar;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isAenar() {
        return aenar;
    }

    public void setAenar(boolean aenar) {
        this.aenar = aenar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Andorian{rank=").append(rank);
        sb.append(", aenar=").append(aenar);
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

    //este metodo como es una caracteristica unica la he metido en la classe andoriano directamente
    public static int typeOfRank() {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] - Trainer");
        System.out.println("[2] - Defender");
        System.out.println("[3] - Fighter");
        System.out.println("[4] - Knight");
        int rank = input.nextInt();

        if (rank < 1 && rank > 4) {
            typeOfRank();
        }
        return rank;
    }

}
