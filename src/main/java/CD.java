import java.math.BigDecimal;
import java.util.Objects;

public class CD extends MusicItem {
    private double duration;

    public CD(String itemID, String theTitle, String theGenre, int theReleaseDate, String theArtist, BigDecimal thePrice, double duration) {
        super(itemID, theTitle, theGenre, theReleaseDate, theArtist, thePrice);
        this.duration = duration;
    }

    //Getters are shown below

    public double getDuration() {
        return duration;
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
                ", Type = CD "+
                ",duration=" + duration +
                '}';
    }


    //Equals Method is shown below

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CD cd = (CD) o;
        return Double.compare(cd.duration, duration) == 0;
    }

    //HashCode is shown Below

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration);
    }
}
