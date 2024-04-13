package group05;

public class Parcel {

    private String id;
    private int length;
    private int width;
    private int height;
    private int noOfDays;
    private int weight; // Changed to int

    // Empty constructor
    public Parcel() {
    }

    // Filled constructor with all data
    public Parcel(String id, int length, int width, int height, int noOfDays, int weight) { // Changed to int
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.noOfDays = noOfDays;
        this.weight = weight;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public int getWeight() { // Changed return type to int
        return weight;
    }

    public void setWeight(int weight) { // Changed parameter type to int
        this.weight = weight;
    }
}
