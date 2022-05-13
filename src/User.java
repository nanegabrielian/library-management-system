import java.util.Objects;

public class User implements Cloneable{
    public enum UserType  {ADMIN, LIBRARIAN, STUDENT};
    private static int currentId = 1;
    private int id;
    private String username;
    private String password;
    private UserType userType;

    public User(String username, String password, UserType userType){
        currentId++;
        this.id = currentId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User(User user){
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.userType = user.userType;
    }

    public UserType getUserType(){
        return this.userType;
    }

    public int getId(){
        return this.id;
    }

    public void setAdminId(){
        this.id = 0;
    }

    public String getUsername(){
        return this.username;
    }

    public boolean login(String username, String password){
        if((username.equals(this.username) && password.equals(this.password))){
            return true;
        }
        else{
            System.out.println("The username or password entered was not correct!");
            return false;
        }
    }

    public boolean logout(){
        return true;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        User user = (User) other;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    public Object clone(){
        try {
            User copy = (User) super.clone();
            return copy;
        }catch(CloneNotSupportedException e){
            return null;
        }

    }

    public String toString(){
        return this.id + " " + this.username;
    }

}
