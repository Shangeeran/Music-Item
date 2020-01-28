package shanga;

public class Shop extends MusicItem {
    private int count;
    private Date saleDate = new Date();

    public Shop(String itemID, String title, String genre, String date, String artist, double price, int count) {
        super(itemID, title, genre, date, artist, price);
        this.count = count;
    }

    public int getCount() {

        return count;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "count=" + count +
                ", date=" + date +
                '}';
    }
}
