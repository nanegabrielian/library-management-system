import java.util.Scanner;

public class Console {
    private Scanner sc;
    private Library library;

    public Console(){
        sc = new Scanner(System.in);
        library = new Library();
    }

    public void login(){
        boolean isLoggedIn = true;
        String username, password;
        System.out.print("Username: ");
        username = sc.nextLine();
        System.out.print("\nPassword: ");
        password = sc.nextLine();

        User currentUser = this.library.findUser(username);

        if(currentUser == null){
             System.out.println("Wrong username or password.");
             return;
         }else if(!currentUser.login(username, password)) {
            return;
        }

        User.UserType userType = currentUser.getUserType();

        printInstructions(userType);

        switch(userType){
            case ADMIN:
                while(isLoggedIn){
                    String input = sc.next();
                    String newUsername;
                    String newPassword;
                    switch(input){
                        case "1":
                            library.showBooks();
                            break;
                        case "2":
                            library.showUsers(User.UserType.STUDENT);
                            break;
                        case "3":
                            library.showUsers(User.UserType.LIBRARIAN);
                            break;
                        case "l":
                            System.out.print("Input the new user's \n username: ");
                            newUsername = sc.nextLine();
                            System.out.print("\npassword: ");
                            newPassword = sc.nextLine();
                            library.addUser(new Librarian(newUsername, newPassword));
                            break;
                        case "s":
                            System.out.print("Input the new user's \n username: ");
                            newUsername = sc.nextLine();
                            System.out.print("\npassword: ");
                            newPassword = sc.nextLine();
                            library.addUser(new Student(newUsername, newPassword));
                            break;
                        case "b":
                            System.out.print("Input the new book's \n title: ");
                            String newTitle = sc.nextLine();
                            System.out.print("\nauthor: ");
                            String newAuthor = sc.nextLine();
                            library.addBook(new Book(newTitle, newAuthor));
                            break;
                        case "o":
                            isLoggedIn = false;
                        default:
                            System.out.println("Wrong input.");
                            break;
                    }
                }
            case LIBRARIAN:

        }




    }

    public void printInstructions(User.UserType user){
        switch(user){
            case ADMIN:
                System.out.println("To see all the \n " +
                                            "   books press - '1'\n" +
                                            "   students press - '2'\n" +
                                            "   librarians press - '3'\n" +
                                    "To add a\n" +
                                            "   librarian press - 'l'\n" +
                                            "   student press - 's'\n" +
                                            "   book press - 'b'\n" +
                                    "To log out press - 'o'");
                break;
            case LIBRARIAN:
                System.out.println("To see all the " +
                                        "   books press - '1'\n" +
                                        "   requests press - '2'\n" +
                                        "   students press - '3'\n" +
                                    "To add a \n" +
                                        "   student press - 's'\n" +
                                        "   book press - 'b'");
                break;
            case STUDENT:
                System.out.println("To see all the \n" +
                                        "   books press - '1'\n" +
                                        "   borrowed books press - '2'\n" +
                                        "   requests press - '3'\n" +
                                    "To request a book press - 'r'");
                break;
        }
    }
}
