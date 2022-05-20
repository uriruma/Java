/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import static Controller.AuthorController.getAuthors;
import Exception.BookException;
import Model.Author;
import Model.Book;

/**
 *
 * @author uriru
 */
public class BookController {
    public static Book getBookByAuthorAndTitle(Author a, String title) throws BookException{
        if (a.getBooksAuthor().isEmpty()){
            throw new BookException("There isn't any book");
        }
        Book book = new Book();
        //I compare the two titles manually as I don't want to go through the equals
        for (Book b : a.getBooksAuthor()) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                book = b;
            }
        }
        return book;
    }
    
    public static void addBookToAuthor(Author a, Book b) throws BookException {
        for (Author a_comp : getAuthors()) {
            if (a_comp.getBooksAuthor().contains(b)) {
                throw new BookException("This book already exists!");
            } 
        }
        a.getBooksAuthor().add(b);
    }
    
    public static void modifyBook(Book b, Author a, String title, int numberOfPages, String genre) throws BookException{
        if (!a.getBooksAuthor().contains(b)) {
            throw new BookException("This book doesn't exists!");
        }
        b.setTitle(title);
        b.setNumberOfPages(numberOfPages);
        b.setGenre(genre);  
    }
    
    public static void deleteBook(Book b, Author a) throws BookException{
        if (!a.getBooksAuthor().contains(b)) {
            throw new BookException("This book doesn't exists!");
        }
        a.getBooksAuthor().remove(b);
    }
    
    public static void searchBook(Book b, Author a) throws BookException{
        
    }
}
