import java.util.Objects;

public class Date {

    private int Day;
    private int Month;
    private int Year;

    public Date(int day, int month, int year) {
        Day = day;
        Month = month;
        Year = year;
    }

    //Getters are shown below

    public int getDay() {
        return Day;
    }

    public int getMonth() {
        return Month;
    }

    public int getYear() {
        return Year;
    }

    //toString()

    @Override
    public String toString() {    //toString()
        return "Date{" +
                "Day=" + Day +
                ", Month=" + Month +
                ", Year=" + Year +
                '}';
    }

    //Equals Method is shown below

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Day == date.Day &&
                Month == date.Month &&
                Year == date.Year;
    }

    //HashCode is shown Below

    @Override
    public int hashCode() {
        return Objects.hash(Day, Month, Year);
    }
}
