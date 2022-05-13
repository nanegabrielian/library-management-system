public class Admin extends User{
    private Library library;

    public Admin(String username, String password){
        super(username, password, UserType.ADMIN);
        this.setAdminId();
    }

    public boolean addUser(String username, String password, User.UserType userType){
        if(library.findUser(username) != null) {
            System.out.println("The username already exists");
            return false;
        }
        if(userType == User.UserType.ADMIN){
            System.out.println("Only one admin is allowed");
            return false;
        }
        if(userType == UserType.STUDENT){
            Student student = new Student(username, password);
            this.library.addUser(student);
            return true;
        }
        if(userType == UserType.LIBRARIAN){
            Librarian librarian = new Librarian(username, password);
            this.library.addUser(librarian);
            return true;
        }

        System.out.println("Something went wrong");
        return false;

    }

    public boolean removeUser(String username){
        User user = this.library.findUser(username);

        if(user == null){
            System.out.println("No such user found");
            return false;
        }

        return this.library.removeUser(username);
    }

    public boolean addBook(String title, String author){
        if(library.findBook(title, author) != null){
            System.out.println("The book with this title already exists.");
            return false;
        }

        Book book = new Book(title, author);
        library.addBook(book);
        return true;
    }

    public boolean removeBook(String title, String author){
        if(library.findBook(title, author) == null){
            System.out.println("No such book");
            return false;
        }
        Book book = library.findBook(title, author);
        return library.removeBook(book);
    }



}
