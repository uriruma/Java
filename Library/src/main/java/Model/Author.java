/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author uriru
 */
public class Author {

    private String name;
    private String surname;
    private String secondSurname;
    private String country;
    private ArrayList<Book> authorBooks;

    public Author(String name, String surname, String secondSurname, String country) {
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.country = country;
        authorBooks = new ArrayList<>();
    }

    //constructor for the contains
    public Author(String name, String surname, String secondSurname) {
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
    }

    public ArrayList<Book> getBooksAuthor() {
        return authorBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        }
        final Author other = (Author) obj;
        if (Objects.equals(this.name, other.name) && (Objects.equals(this.surname, other.surname))
                && (Objects.equals(this.secondSurname, other.secondSurname))) {
            return true;
        }
        return false;
    }
    
    //this is only for testing in the console
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Author{");
        sb.append("name=").append(name);
        sb.append(", surname=").append(surname);
        sb.append(", secondSurname=").append(secondSurname);
        sb.append(", country=").append(country);
        sb.append(", booksAuthor=").append(authorBooks);
        sb.append('}');
        return sb.toString();
    }

}
