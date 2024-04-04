package group_05;

public class Parcel {

    private double length;
    private double width;
    private double height;
    private int noOfDays;

    // Empty constructor
    public Parcel() {
    }

    // Filled constructor with all data
    public Parcel(double length, double width, double height, int noOfDays) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.noOfDays = noOfDays;
    }

    // Getters and setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }
}