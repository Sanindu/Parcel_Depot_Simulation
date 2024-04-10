package group05;

public class Parcel {

    private String id;
    private int length;
    private int width;
    private int height;
    private int noOfDays;
    private int weight;
   // private String destination;

    public Parcel() {
    }

    public Parcel(String id, int length, int width, int height, int noOfDays, int weight /*, String destination*/) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.noOfDays = noOfDays;
        this.weight = weight;
      //  this.destination = destination;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

//    public String getDestination() {
//        return destination;
//    }

//    public void setDestination(String destination) {
//        this.destination = destination;
//    }

    public double parcelFee(int length, int width, int height, int weight, int noOfDays) {
        double totalFee;
        double dimensionFare;
        double storageDurationFee;
        double discounts;
        String parcelType;
        int dimensionalWeight;

        dimensionalWeight = dimensionWeight(length, width, height);
        // Selects the greater of the two weights (actual weight or dimensional weight) as the chargeable weight
        if (dimensionalWeight != -1 && dimensionalWeight > weight) {
            weight = dimensionalWeight;
        }
        if (weight <= Constants.SMALL_WEIGHT_LIMIT) {
            parcelType = "SMALL";
            dimensionFare = Constants.SMALL_FARE;
        } else if (weight <= Constants.MEDIUM_WEIGHT_LIMIT) {
            parcelType = "MEDIUM";
            dimensionFare = Constants.MEDIUM_FARE;
        } else if (weight <= Constants.LARGE_WEIGHT_LIMIT) {
            parcelType = "LARGE";
            dimensionFare = Constants.LARGE_FARE;
        } else {
            System.out.println("Sorry! Out of Range Parcel Dimension");
            return -1;
        }
        // Fee Calculation for Number of Days in the Deport
        if (noOfDays <= 2) {
            storageDurationFee = 0;
        } else storageDurationFee = Constants.PER_DAY_RATE * noOfDays;
        discounts = discount(parcelType, dimensionFare);
        totalFee = Constants.BASE_FARE + dimensionFare + storageDurationFee - discounts;
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
            dimensionalWeight = (length * width * height) / Constants.VOLUMETRIC_FACTOR;
            return (int) dimensionalWeight;
        } catch (ArithmeticException e) {
            System.out.println("Error in dimensionWeight: " + e);
            return -1;
        }
    }
}