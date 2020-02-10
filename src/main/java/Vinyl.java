import java.math.BigDecimal;
import java.util.Objects;

public class Vinyl extends MusicItem {
    private double speed;
    private double diameter;

    public Vinyl(String itemID, String theTitle, String theGenre, int theReleaseDate, String theArtist, BigDecimal thePrice, double speed, double diameter) {
        super(itemID, theTitle, theGenre, theReleaseDate, theArtist, thePrice);
        this.speed = speed;
        this.diameter = diameter;
    }

    //Getters are shown below

    public double getSpeed() {
        return speed;
    }

    public double getDiameter() {
        return diameter;
    }

    //toString()

    @Override
    public String toString() {
        return "{" +
                " Item ID =" + itemID +
                ", Title ='" + theTitle + '\'' +
                ", Genre ='" + theGenre + '\'' +
                ", ReleaseDate =" + theReleaseDate +
                ", Artist ='" + theArtist + '\'' +
                ", Price =" + thePrice +
                ", Speed =" + speed +
                ", Diameter =" + diameter +
                ", Type = Vinyl "+
                '}';
    }

    //Equals Method is shown below

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vinyl vinyl = (Vinyl) o;
        return Double.compare(vinyl.speed, speed) == 0 &&
                Double.compare(vinyl.diameter, diameter) == 0;
    }

    //HashCode is shown Below

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed, diameter);
    }
}
