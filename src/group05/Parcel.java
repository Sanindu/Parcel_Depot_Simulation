public class Parcel {

    private String id;
    private int length;
    private int width;
    private int height;
    private int noOfDays;
    private double weight; 
    private String destination; 
    
    public Parcel() {
    }

    public Parcel(String id, int length, int width, int height, int noOfDays, double weight, String destination) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.noOfDays = noOfDays;
        this.weight = weight;
        this.destination = destination;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
