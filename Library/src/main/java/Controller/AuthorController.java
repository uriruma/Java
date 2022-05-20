/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exception.AuthorException;
import Model.Author;
import java.util.ArrayList;

/**
 *
 * @author uriru
 */
public class AuthorController {

    private static ArrayList<Author> arrayAuthors = new ArrayList<>();

    public static ArrayList<Author> getAuthors() {
        return arrayAuthors;
    }

    public static void addAuthor(Author a) throws AuthorException {
        if (arrayAuthors.contains(a)) {
            throw new AuthorException("This author already exists!");
        }
        arrayAuthors.add(a);
    }

    public static void modifyAuthor(Author a, String all) throws AuthorException {
        String str[] = all.split(" ");
        if (!arrayAuthors.contains(a)) {
            throw new AuthorException("This author doesn't exist!");
        }
        a.setName(str[0]);
        a.setSurname(str[1]);
        a.setSecondSurname(str[2]);
        a.setCountry(str[3]);
    }

    public static void deleteAuthor(Author a) throws AuthorException {
        
        if (!arrayAuthors.contains(a)) {
            throw new AuthorException("This author doesn't exist exist!");
        }
        arrayAuthors.remove(a);
    }
    
    
    public static Author getAuthorByFullName(String name, String surname, String secondSurname) throws AuthorException {
        if (!arrayAuthors.contains(new Author(name, surname, secondSurname))) {
            throw new AuthorException("This author doesn't exists");
        }
        return arrayAuthors.get(arrayAuthors.indexOf(new Author(name, surname, secondSurname)));
    }
}
