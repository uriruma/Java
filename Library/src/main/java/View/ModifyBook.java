/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import static Controller.AuthorController.getAuthorByFullName;
import static Controller.AuthorController.getAuthors;
import static Controller.BookController.getBookByAuthorAndTitle;
import static Controller.BookController.modifyBook;
import static Data.DataValidation.isValidISBN;
import static Data.DataValidation.isValidString;
import Exception.AuthorException;
import Exception.BookException;
import Model.Author;
import Model.Book;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author uriru
 */
public class ModifyBook extends javax.swing.JDialog {

    Book bookSelected;
    Author authorSelected;

    /**
     * Creates new form ModifyBook
     */
    public ModifyBook(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(Color.white);
        warningLabel.setVisible(false);//this is a warning label used later
        //add all the books with the author name to the combobox
        for (Author a : getAuthors()) {
            for (Book b : a.getBooksAuthor()) {
                booksComboBox.addItem(b.getTitle() + " - "
                        + a.getName() + " " + a.getSurname() + " " + a.getSecondSurname());
            }
        }
        //author book selected by default by the title with the author
        String str = (String) booksComboBox.getSelectedItem();
        String[] fullString = str.split(" - ");
        String[] strAuthor = fullString[1].split(" ");
        String title = fullString[0];

        try {
            //this will fill the texts fields
            authorSelected = getAuthorByFullName(strAuthor[0], strAuthor[1], strAuthor[2]);
            bookSelected = getBookByAuthorAndTitle(authorSelected, title);

            isbnTextField.setText(bookSelected.getIsbn());
            titleTextField.setText(bookSelected.getTitle());
            numberOfPagesSpinner.setValue(bookSelected.getNumberOfPages());
            genreComboBox.setSelectedItem(bookSelected.getGenre());
        } catch (BookException | AuthorException ex) {
            //it shouldn't be done, but just in case
            JOptionPane.showMessageDialog(this, "This book doesn't exist", "Empty data", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bookLabel = new javax.swing.JLabel();
        isbnLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();
        numberOfPagesLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        isbnTextField = new javax.swing.JTextField();
        titleTextField = new javax.swing.JTextField();
        numberOfPagesSpinner = new javax.swing.JSpinner();
        booksComboBox = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        genreComboBox = new javax.swing.JComboBox<>();
        backButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        bookLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bookLabel.setText("Book:");

        isbnLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        isbnLabel.setText("ISBN:");

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        titleLabel.setText("Title:");

        genreLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        genreLabel.setText("Genre:");

        numberOfPagesLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        numberOfPagesLabel.setText("N?? Pages:");

        authorLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        isbnTextField.setEditable(false);

        numberOfPagesSpinner.setToolTipText("");

        booksComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        booksComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                booksComboBoxItemStateChanged(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        warningLabel.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        warningLabel.setText("You must rewrite a valid option in the red camps.");

        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comedy", "Drama", "Fantasy", "Thriller", "Action" }));

        backButton1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        backButton1.setText("<");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel)
                        .addComponent(isbnLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(bookLabel)
                        .addGap(18, 18, 18)
                        .addComponent(booksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(warningLabel)
                        .addGap(18, 18, 18)
                        .addComponent(confirmButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genreComboBox, 0, 283, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(numberOfPagesSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                .addComponent(isbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(titleTextField)))))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(genreLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numberOfPagesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton1)
                    .addComponent(booksComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isbnLabel)
                    .addComponent(isbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberOfPagesSpinner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberOfPagesLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genreLabel))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void booksComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_booksComboBoxItemStateChanged
        String str = (String) booksComboBox.getSelectedItem();
        String[] fullString = str.split(" - ");
        String[] strAuthor = fullString[1].split(" ");
        String title = fullString[0];
        try {
            //we select the author by the last 3 Strings of the comboBox as the title of the book could be anything
            authorSelected = getAuthorByFullName(strAuthor[0], strAuthor[1], strAuthor[2]);
            bookSelected = getBookByAuthorAndTitle(authorSelected, title);
            //this will fill the texts fields
            isbnTextField.setText(bookSelected.getIsbn());
            titleTextField.setText(bookSelected.getTitle());
            numberOfPagesSpinner.setValue(bookSelected.getNumberOfPages());
            genreComboBox.setSelectedItem(bookSelected.getGenre());
        } catch (BookException | AuthorException ex) {
            //it shouldn't be done, but just in case
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Unable to find the book", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_booksComboBoxItemStateChanged

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        //collecting the book text fields with a trim for the spaces at the beggining or the end
        String isbn = isbnTextField.getText().trim();
        String title = titleTextField.getText().trim();
        int numberOfPages = Math.abs((int) numberOfPagesSpinner.getValue());//we get the absolute value
        String genre = (String) genreComboBox.getSelectedItem();
        boolean valid = true;//if any of the camps is not valid this will be false

        //if any text field is in blank an error is shown
        if (isbn.isEmpty() || title.isEmpty() || title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You must fill every camp of the Author", "Empty data", JOptionPane.ERROR_MESSAGE);
        } else {
            //here we check if all the Strings are valid
            if (isValidISBN(isbn)) {//in theory it always has to be valid because it doesn't change
                isbnTextField.setForeground(Color.GREEN);//if it is valid is green
            } else {
                isbnTextField.setForeground(Color.RED);//if it is not valid is red
                valid = false;
            }
            if ((title.length() <= 20)) {
                titleTextField.setForeground(Color.GREEN);
            } else {
                titleTextField.setForeground(Color.RED);
                valid = false;
            }
            if (isValidString(genre)) {
                genreComboBox.setForeground(Color.GREEN);
            } else {
                genreComboBox.setForeground(Color.RED);
                valid = false;
            }
            if (numberOfPages != 0) {
                numberOfPagesSpinner.setForeground(Color.GREEN);
            } else {
                numberOfPagesSpinner.setForeground(Color.RED);
                valid = false;
            }

            //if all the variables are valid then we proceed to add the book
            if (valid) {
                warningLabel.setVisible(false);//this hides the warning, there is no error
                try {
                    modifyBook(bookSelected, authorSelected, title, numberOfPages, genre);
                    JOptionPane.showMessageDialog(this, "Book modified with exit!", "OK", JOptionPane.INFORMATION_MESSAGE);
                    dispose();//this will close the window 
                } catch (BookException ex) {//it shouldn't be done but just in case.
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Unable to modify the book", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                warningLabel.setVisible(true);//we make the warning visible to let the user fix the error
            }
        }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_backButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyBook dialog = new ModifyBook(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton backButton1;
    private javax.swing.JLabel bookLabel;
    private javax.swing.JComboBox<String> booksComboBox;
    private javax.swing.JButton confirmButton;
    private javax.swing.JComboBox<String> genreComboBox;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JLabel isbnLabel;
    private javax.swing.JTextField isbnTextField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel numberOfPagesLabel;
    private javax.swing.JSpinner numberOfPagesSpinner;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
