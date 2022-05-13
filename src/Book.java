import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
public class Book implements Comparable<Book>, Cloneable{
    private static final int borrowPeriod = 30;
    private static int currentId = 1;
    public enum Genre {SCIENCE, FANTASY, SCIENCE_FICTION, CLASSICS, DETECTIVE, BIOGRAPHY, HISTORY, POETRY};
    private String title;
    private String author;
    private Genre genre;
    private int id;
    private Date publishDate;
    private boolean available;
    private Date issueDate;
    private Date dueDate;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.id = currentId;
        currentId++;
    }
    public Book(String title, String author, Genre genre, Date publishDate, boolean available){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = currentId;
        this.publishDate = publishDate;
        currentId++;
    }
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }
    public void borrowBook(Date date){

        if(!this.available) System.out.println("The book is not available!");

        else {
            this.available = false;
            this.issueDate = date;
        }
    }
    public void returnBook(){
        if(this.available) System.out.println("The book is not borrowed!");

        else this.available = true;
    }

    public boolean isAvailable(){
        return available;
    }

    void setIssueDate(String date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            issueDate = dateFormat.parse(date);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean equals(Object other){
        if(other == null) return false;
        if(other.getClass() != this.getClass()) return false;

        return  this.title.equals(((Book) other).title) &&
                this.author.equals(((Book) other).author) &&
                this.publishDate.equals(((Book) other).publishDate);
    }

    public int compareTo(Book other){
        if(!this.author.equals(other.author)) return this.author.compareTo(other.author);
        //if(!this.title.equals(other.title)) return this.title.compareTo(other.title);

        return this.publishDate.compareTo(other.publishDate);
    }

    public String toString(){
        return id + " " + title + " " + author;
    }

    public Object clone(){
        try{
            Book copy = (Book) super.clone();
            return copy;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

}
