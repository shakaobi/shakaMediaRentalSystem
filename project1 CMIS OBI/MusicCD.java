//import java.time.Year;

public class MusicCD extends Media {
    private int minutes;

    public MusicCD(int id, String title, int yearPublished, int minutes) {
        super(id, title, yearPublished);
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public double calculateRentalFee() {
        return Math.round(
                (minutes * 0.02 + (getYearPublished() == getCurrentYear() ? 1.0 : 0.0)) * 100.00) / 100.00;
    }

    @Override
    public String toString() {
        return "MusicCD [ " +
                super.toString() +
                ", length=" + minutes + "min, " +
                "available=" + isAvailable() + "]   " +
                String.format("Rental fee=$%.2f", calculateRentalFee());
    }
}