package shanga;

import java.util.Objects;

public abstract class MusicItem implements Comparable<MusicItem>{

    protected String itemID;
    protected String title;
    protected String genre;
    protected String date;
    protected String artist;
    protected double price;


    public MusicItem(String itemID, String title, String genre, String date, String artist, double price) {
        this.itemID = itemID;
        this.title = title;
        this.genre = genre;
        this.date = date;
        this.artist = artist;
        this.price = price;
    }

    public String getItemID() {
        return itemID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicItem musicItem = (MusicItem) o;
        return Double.compare(musicItem.price, price) == 0 &&
                Objects.equals(itemID, musicItem.itemID) &&
                Objects.equals(title, musicItem.title) &&
                Objects.equals(genre, musicItem.genre) &&
                Objects.equals(artist, musicItem.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, title, genre, artist, price);
    }



    @Override
    public int compareTo(MusicItem o) {
        return 0;
    }

    @Override
    public String toString() {
        return "MusicItem{" +
                "itemID='" + itemID + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                '}';
    }
}
