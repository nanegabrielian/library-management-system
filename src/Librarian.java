import java.io.*;

public class Librarian extends User {

    public Librarian(String username, String password){

        super(username, password, UserType.LIBRARIAN);

    }


    public Object clone() {
        Librarian copy = (Librarian) super.clone();
        return copy;
    }


/*

    public void addStudent(){

    }

    public void addBook(){

    }

    public void removeBook(){}

    public void issueBook(Book book, Student student){
        student.borrowBook(book);
    }

*/

}
