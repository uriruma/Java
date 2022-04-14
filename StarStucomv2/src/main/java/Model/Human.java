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
public class Human extends Being {

    protected int age;
    protected boolean gender;
    protected static final int lvl = 1;

    public Human(int age, boolean gender, String name) {
        super(name);
        this.age = age;
        this.gender = gender;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Human{age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", lvl=").append(lvl);
        sb.append('}');
        return sb.toString();
    }

}
