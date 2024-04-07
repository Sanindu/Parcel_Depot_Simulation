package group05;

public class Parcel {

    private String id; 
    private double length;
    private double width;
    private double height;
    private int noOfDays;
    private double weight;
    private String destination;

    public Parcel() {
    }

    public Parcel(String id, double length, double width, double height, int noOfDays, double weight, String destination) {
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
    
    public int parcelFee(double length, double width, double weight, int noOfDays, int discounts) {
    	int totalFee;
    	int dimentionFare;
    	int StorageDurationFee;
    	String parcelType;
    	

    	if (weight ==0 || length == 0 || width == 0 ) {
    		System.out.println("Invalid Dimension");
    		return -1;
    	}
    	else if (weight <= Constants.SMALL_WEIGHT_LIMIT && length <= Constants.SMALL_MAX_LENGTH 
    			 && width<= Constants.SMALL_MAX_WIDTH) {
    		parcelType = "SMALL";
    		dimentionFare = Constants.SMALL_FARE;
    		System.out.println("Small Parcel");
    	}
    	else if (weight <= Constants.MEDIUM_WEIGHT_LIMIT && length <= Constants.MEDIUM_MAX_LENGTH 
   			 && width<= Constants.MEDIUM_MAX_WIDTH) {
    		parcelType = "MEDIUM";
    		dimentionFare = Constants.MEDIUM_FARE;
    		System.out.println("Medium Parcel");
    	}
    	//No Width limitation for Large Parcels
    	else if (weight <= Constants.LARGE_WEIGHT_LIMIT && length <= Constants.LARGE_MAX_LENGTH) {
    		parcelType = "LARGE";
    		dimentionFare = Constants.LARGE_FARE;
    		System.out.println("Large Parcel");
    	}
    	else {
    		System.out.println("Sorry! Out of Range Parcel Dimension");
    		return -1;
    	}

    	// Fee Calculation for Number of Days in the Deport
    	if(noOfDays == 2) {
    		StorageDurationFee = 0;
    	}
        else StorageDurationFee = Constants.PER_DAY_RATE*noOfDays;
    		
    	totalFee = Constants.BASE_FARE + dimentionFare + StorageDurationFee - discounts;
    	
    	return totalFee;
    	
    }
}