/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author uriru
 */
public class Book {

    private String isbn;
    private String title;
    private int numberOfPages;
    private String genre;

    public Book (){
        
    }
    public Book(String title) {
        this.title = title;
    }

    public Book(String isbn, String title, int numberOfPages, String genre) {
        this.isbn = isbn;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        final Book other = (Book) obj;
        /*if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }*/
        if (!Objects.equals(this.isbn, other.isbn) /*|| !Objects.equals(this.isbn, other.isbn)*/){
            return false;
        }
        /*if (Objects.equals(this.isbn, other.isbn) && (Objects.equals(this.title, other.title))) {
            return false;
        }*/
        return true;
    }
}
