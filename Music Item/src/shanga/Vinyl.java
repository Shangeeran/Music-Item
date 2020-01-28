package shanga;

public class Vinyl extends MusicItem {
    private double speed;
    private double diameter;

    public Vinyl(String itemID, String title, String genre, String date, String artist, double price, double speed, double diameter) {
        super(itemID, title, genre, date, artist, price);
        this.speed = speed;
        this.diameter = diameter;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }


}
