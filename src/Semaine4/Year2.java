package Semaine4;

public class Year2 {
    public static final int MIN_VALUE = -999_999_999;
    public static final int MAX_VALUE = 999_999_999;
    private final int year;

    public static boolean isLeap(long year) {
        return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
    }

    public static Year2 of(int isoYear) {
        if(isoYear <= MIN_VALUE || isoYear >= MAX_VALUE){
            throw new java.time.DateTimeException("la date n'est pas valide");
        }
        else {
            return new Year2(isoYear);
        }
    }

    private Year2(int year) {
        this.year = year;
    }

    public int getValue() {
        return this.year;
    }

    public boolean isLeap() {
        return Year2.isLeap(this.year);
    }

    public int length() {
        return this.isLeap() ? 366 : 365;
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    public boolean isAfter(Year2 other) {
        return this.year > other.year;
    }

    public boolean isBefore(Year2 other) {
        return this.year < other.year;
    }

    public Year2 minusYears(long yearTosubract){
        return new Year2(this.year - (int)yearTosubract);
    }

    public Year2 plusYears(long yearToAdd){
        return new Year2(this.year + (int)yearToAdd);
    }

    public static Year2 parse(String text) {
        return new Year2(Integer.parseInt(text));
    }
}
