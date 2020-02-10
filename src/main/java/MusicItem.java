import java.math.BigDecimal;
import java.util.Objects;

abstract public class MusicItem implements Comparable<MusicItem> {
    protected String itemID;
    protected String theTitle;
    protected String theGenre;
    protected int theReleaseDate;
    protected String theArtist;
    protected BigDecimal thePrice;

    public MusicItem(String itemID, String theTitle, String theGenre, int theReleaseDate, String theArtist, BigDecimal thePrice) {  //Constructor
        this.itemID = itemID;
        this.theTitle = theTitle;
        this.theGenre = theGenre;
        this.theReleaseDate = theReleaseDate;
        this.theArtist = theArtist;
        this.thePrice = thePrice;
    }

    //Getters are shown below

    public String getItemID() {
        return itemID;
    }

    public String getTheTitle() {
        return theTitle;
    }

    public String getTheGenre() {
        return theGenre;
    }

    public int getTheReleaseDate() {
        return theReleaseDate;
    }

    public String getTheArtist() {
        return theArtist;
    }

    public BigDecimal getThePrice() {
        return thePrice;
    }

    @Override
    public int compareTo(MusicItem o) {
        return theTitle.compareTo(o.getTheTitle());
    }

    //toString()

    @Override
    public String toString() {
        return "MusicItem{" +
                "itemID=" + itemID +
                ", theTitle='" + theTitle + '\'' +
                ", theGenre='" + theGenre + '\'' +
                ", theReleaseDate=" + theReleaseDate +
                ", theArtist='" + theArtist + '\'' +
                ", thePrice=" + thePrice +
                '}';
    }

    //Equals Method is shown below

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicItem item = (MusicItem) o;
        return theReleaseDate == item.theReleaseDate &&
                Objects.equals(itemID, item.itemID) &&
                Objects.equals(theTitle, item.theTitle) &&
                Objects.equals(theGenre, item.theGenre) &&
                Objects.equals(theArtist, item.theArtist) &&
                Objects.equals(thePrice, item.thePrice);
    }

    //HashCode is shown Below

    @Override
    public int hashCode() {
        return Objects.hash(itemID, theTitle, theGenre, theReleaseDate, theArtist, thePrice);
    }
}

