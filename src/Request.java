public class Request {

    private String username;
    private Book book;

    public Request(String username, Book book){
        this.username = username;
        this.book = book;
    }

    public String toString(){
        return username + " requested " + book;
    }


}
