/*
 *author: camesha obi  
 *This program uses inheritance to display id,title
 *year published, size, and of music items via GUI's 
 *child class
 */
public class MovieDVD extends Media {
	//attributes
    private double size;
    //Constructors
    public MovieDVD(int id, String title, int yearPublished, double size) {
        super(id, title, yearPublished);
        this.size = size;
    }
    public double getSize() {//getters
        return size;
    }

    public void setSize(double size) {//setters
        this.size = size;
    }

    @Override
    public double calculateRentalFee() {//basic fee
        return RENTAL_FEE;
    }

    @Override
    public String toString() {
        return "MovieDVD [ " +
                super.toString() +
                ", size=" + size + "MB, " +
                "available=" + isAvailable() + "]   " +
                String.format("Rental fee=$%.2f", calculateRentalFee());
    }
}