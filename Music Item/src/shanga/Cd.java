package shanga;

import java.util.Objects;

public class Cd extends MusicItem {
    private int duration;

    public Cd(String itemID, String title, String genre, String date, String artist, double price, int duration) {
        super(itemID, title, genre, date, artist, price);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cd cd = (Cd) o;
        return duration == cd.duration;
    }



    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), duration);
    }

    @Override
    public String toString() {
        return "Cd{" +
                "duration=" + duration +
                ", itemID='" + itemID + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                '}';
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
