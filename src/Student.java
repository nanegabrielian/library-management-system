import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Book> borrowedBooks;
    private boolean accountOnHold = false;
    private static final int MAX_BOOKS = 5;

    public Student(String username, String password){
        super(username, password, UserType.STUDENT);
        this.borrowedBooks = new ArrayList<Book>(0);
    }

    public void viewBorrowed(){
        if(this.borrowedBooks.size() == 0)
            System.out.println("No books borrowed");
        else{
            System.out.println();
            for(int i = 0; i < borrowedBooks.size(); i++){
                System.out.println(borrowedBooks.get(i));
            }
        }
    }

    @Override
    public Object clone() {
        Student copy = (Student) super.clone();
        for(int i = 0; i < borrowedBooks.size(); i++){
            copy.borrowedBooks.add((Book) borrowedBooks.get(i).clone());
        }
        return copy;
    }

    public void returnBook(){

    }
}
