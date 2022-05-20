package Controller;

import static Controller.AuthorController.getAuthorByFullName;
import static Controller.AuthorController.getAuthors;
import Exception.AuthorException;
import Model.Author;
import Model.Book;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author uriru
 */
public class FileController {

    public static void writeAuthorFile() {
        try {
            File file = new File("Authors.txt");
            if (!file.exists()) {
                System.out.println("Creating Authors.txt");
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileWriter newFile = new FileWriter(file, false);
                for (Author a : getAuthors()) {
                    newFile.write(a.getName() + "\t\t" + a.getSurname() + "\t\t"
                            + a.getSecondSurname() + "\t\t" + a.getCountry() + "\t\t");
                    for (Book b : a.getBooksAuthor()) {
                        newFile.write("\t\t" + b.getIsbn());
                    }
                    newFile.write("\n");
                }
                newFile.close();
            } else {
                System.out.println("Couldn't acces to Authors.txt");
            }
        } catch (IOException ex) {
            System.out.println("Unable to save/write Authors.txt");
        }
    }

    public static void writeBookFile() {
        try {
            File file = new File("Books.txt");
            if (!file.exists()) {
                System.out.println("Creating Books.txt");
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileWriter newFile = new FileWriter(file, false);
                for (Author a : getAuthors()) {
                    for (Book b : a.getBooksAuthor()) {
                        newFile.write(b.getIsbn() + "\t\t" + b.getTitle() + "\t\t"
                                + b.getNumberOfPages() + "\t\t" + b.getGenre() + "\t\t"
                                + a.getName() + "\t\t" + a.getSurname() + "\t\t" + a.getSecondSurname());
                        /*for (Author aut : getAuthors()) {
                            newFile.write("\t\t" + aut.getName() + "\t\t" + aut.getSurname() + "\t\t" + aut.getSecondSurname());
                        }*/
                        newFile.write("\n");
                    }
                }
                newFile.close();
            } else {
                System.out.println("Couldn't acces to Races.txt");
            }
        } catch (IOException ex) {
            System.out.println("Unable to write/save Races.txt");
        }
    }

    public static void readAuthorFile() {
        try {
            File file = new File("Authors.txt");
            if (!file.exists()) {
                System.out.println("Couldn't read Authors.txt. File doesn't exists.");
            } else {
                if (file.canRead()) {
                    FileReader newFile = new FileReader(file);
                    BufferedReader newFile2 = new BufferedReader(newFile);

                    String line;
                    while ((line = newFile2.readLine()) != null) {
                        String[] authorData = line.split("\t\t");
                        getAuthors().add(new Author(authorData[0], authorData[1],
                                (authorData[2]), (authorData[3])));
                    }
                    newFile.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Unable to load Authors.txt");
        }
    }

    public static void readBookFile() {
        try {
            File file = new File("Books.txt");
            if (!file.exists()) {
                System.out.println("Couldn't read Books.txt. File doesn't exists.");
            } else {
                if (file.canRead()) {
                    FileReader newFile = new FileReader(file);
                    BufferedReader newFile2 = new BufferedReader(newFile);

                    String line;
                    while ((line = newFile2.readLine()) != null) {
                        String[] bookData = line.split("\t\t");
                        Author a = getAuthorByFullName(bookData[4], bookData[5], bookData[6]);
                        a.getBooksAuthor().add(new Book(bookData[0], bookData[1],
                                Integer.parseInt(bookData[2]), bookData[3]));
                    }
                    newFile.close();
                }
            }
        } catch (AuthorException | IOException ex) {
            System.out.println("Unable to load Races.txt");
        }

    }

    /*public static void relateAuthorsAndBooks() {
        try {
            File file = new File("Authors.txt");
            if (!file.exists()) {
                System.out.println("Couldn't relate authors with books");
            } else {
                if (file.canRead()) {
                    FileReader newFile = new FileReader(file);
                    BufferedReader newFile2 = new BufferedReader(newFile);
                    String line;
                    while ((line = newFile2.readLine()) != null) {
                        String[] authorData = line.split("\t\t");
                        Author a = getAuthorByFullName(authorData[0], authorData[1], authorData[2]);
                        for (int i = 5; i < authorData.length; i++) {
                            Book b = getBookByAuthorAndTitle(a, authorData[i]);
                            a.getBooksAuthor().add(b);
                        }
                    }
                    newFile.close();
                }
            }
        } catch (AuthorException | BookException | IOException ex) {
            System.out.println("Couldn't relate");
        }
    }*/
}
