//import java.time.Year;

public class EBook extends Media {
    private int chapters;

    public EBook(int id, String title, int yearPublished, int chapters) {
        super(id, title, yearPublished);
        this.chapters = chapters;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    @Override
    public double calculateRentalFee() {
        return Math.round(
            (chapters * 0.10 + (getYearPublished() == getCurrentYear() ? 1.0 : 0.0)) * 100.00) / 100.00;
    }

    @Override
    public String toString() {
        return "EBook [ " +
                super.toString() +
                ", chapters=" + chapters +
                ", available=" + isAvailable() + "]   " +
                String.format("Rental fee=$%.2f", calculateRentalFee());
    }
}