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

    public double parcelFee(int length, int width, int height, int weight, int noOfDays) {
        double totalFee;
        double dimensionFare;
        double StorageDurationFee;
        double discounts;
        String parcelType;
        int dimensionalWeight;

        dimensionalWeight = dimensionWeight(length, width, height);
        // Selects the greater of the two weights (actual weight or dimensional weight) as the chargeable weight
        if (dimensionalWeight != 0 && dimensionalWeight > weight) {
            weight = dimensionalWeight;
        }
        if (weight <= Constants.SMALL_WEIGHT_LIMIT) {
            parcelType = "SMALL";
            dimensionFare = Constants.SMALL_FARE;
        }
        else if (weight <= Constants.MEDIUM_WEIGHT_LIMIT) {
            parcelType = "MEDIUM";
            dimensionFare = Constants.MEDIUM_FARE;
        }
        else if (weight <= Constants.LARGE_WEIGHT_LIMIT) {
            parcelType = "LARGE";
            dimensionFare = Constants.LARGE_FARE;
        } else {
            System.out.println("Sorry! Out of Range Parcel Dimension");
            return -1;
        }

        // Fee Calculation for Number of Days in the Deport
        if (noOfDays == 2) {
            StorageDurationFee = 0;
        } else StorageDurationFee = Constants.PER_DAY_RATE * noOfDays;
        discounts = discount(parcelType, dimensionFare);
        totalFee = Constants.BASE_FARE + dimensionFare + StorageDurationFee - discounts;
        System.out.println("Parcel Type : " + parcelType);
        String formattedFee = String.format("%.2f", totalFee);
        System.out.println("Parcel Total Fee : GBP " + formattedFee);
        return totalFee;
    }

    // There will be a discount for the dimension fare if the parcel type is Large
    public double discount(String parcelType, double dimensionFare) {
        double discount;
        if (parcelType.equals("LARGE")) {
            discount = Constants.DISCOUNT_RATE * dimensionFare;
        } else discount = 0.0;
        return discount;
    }

    public int dimensionWeight(int length, int width, int height) {
        double dimensionalWeight;
        //Calculate Dimensional Weight: Divide the volume in cubic meters by the carrier's volumetric factor.
        // The result is the dimensional weight of the package in kilograms (kg).
        try {
            dimensionalWeight = (length * width * height) / (1000000 * Constants.VOLUMETRIC_FACTOR);
            return (int) dimensionalWeight;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
            return 0;
        }
    }
}