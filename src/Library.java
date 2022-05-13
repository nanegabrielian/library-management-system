import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;
    private ArrayList<Request> requests;

    public Library(){
        books = new ArrayList<>();
        users = new ArrayList<>();
        requests = new ArrayList<>();


        users.add(new Admin("library", "admin"));
    }

    public User findUser(String username){
        for(int i=0;i<this.users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                return  new User (users.get(i));
            }
        }
        return null;
    }
    public void addUser(User user){
        this.users.add(user);
    }

    public boolean removeUser(String username){
        User user = this.findUser(username);

        for(int i=0;i<this.users.size();i++){
            if(users.get(i).getUsername() == username){
                users.remove(i);
                return true;
            }
        }
        return false;

    }

    public Book findBook(String title, String author){
        for(int i=0; i < books.size();i++){
            if(books.get(i).getTitle().equals(title) && books.get(i).getAuthor().equals(author)){
                return (Book)books.get(i).clone();
            }
        }
        return null;
    }

    public void addBook(Book book){

        this.books.add(book);

    }

    public boolean removeBook(Book book){

        for(int i=0;i<this.books.size();i++){
            if(users.get(i).equals(book)){
                books.remove(i);
                return true;
            }
        }
        return false;

    }

    public void showUsers(User.UserType userType){
        if(users.size() == 0){
            System.out.println("Currently no users.");
            return;
        }
        System.out.println("All the users in the library are: ");
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserType() == userType)
               System.out.println(users.get(i));
        }
    }

    public void showBooks(){
        if(books.size() == 0){
            System.out.println("Currently no books.");
            return;
        }
        System.out.println("All the books in the library are: ");
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i));
        }
    }
}
