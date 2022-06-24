/*
 *author: camesha obi 
 *This program uses inheritance to display id,title and
 *year publishedof music items via GUI's 
 *parent class
 */
import java.util.Calendar;

public abstract class Media {
    public static final double RENTAL_FEE = 3.50;//Constant basic fee
    //attributes
    private final int id;
    private String title;
    private int yearPublished;
    private boolean available;
    //Constructors
    public Media(int id, String title, int yearPublished) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
        this.available = true;
    }

    public int getId() {//getters
        return id;
    }

    public String getTitle() {//getters
        return title;
    }

    public void setTitle(String title) {//setters
        this.title = title;
    }

    public int getYearPublished() {//getters
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {//setters
        this.yearPublished = yearPublished;
    }

    public abstract double calculateRentalFee();

    public int getCurrentYear() {//getters
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public boolean isAvailable() {//getters
        return available;
    }

    public void setAvailable() {//setters
        this.available = true;
    }
    public void setRented() { this.available = false; }//setters

    @Override
    public String toString() {
        return "id=" + id +
                ", title=" + getTitle() +
                ", year=" + yearPublished;
    }
}