package application;

public class Item {
	private String id;
    private int weight;
    private String dimensions;
    private int deportDays;

    public Item(String id, int weight, String dimensions, int deportDays) {
        this.id = id;
        this.weight = weight;
        this.dimensions = dimensions;
        this.deportDays = deportDays;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public int getDeportDays() {
        return deportDays;
    }

}