package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class ParcelCollection {
    private Map<String, Parcel> parcels;
    private Queue<String[]> customerQueue;
    private List<String[]> combinedDataList;

    public ParcelCollection() {
        this.parcels = new HashMap<>();
        this.customerQueue = new LinkedList<>();
        this.combinedDataList = new ArrayList<>();
    }

    // Method to add a parcel to the collection
    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getId(), parcel);
    }

    // Method to retrieve a parcel by ID
    public Parcel getParcel(String id) {
        return parcels.get(id);
    }

    // Method to remove a parcel by ID
    public void removeParcel(String id) {
        parcels.remove(id);
    }

    // Method to update a parcel
    public void updateParcel(String id, Parcel updatedParcel) {
        if (parcels.containsKey(id)) {
            parcels.put(id, updatedParcel);
        } else {
            System.out.println("Parcel with ID " + id + " not found.");
        }
    }

    // Method to get the count of parcels in the collection
    public int getParcelCount() {
        return parcels.size();
    }

    // Method to check if the collection is empty
    public boolean isEmpty() {
        return parcels.isEmpty();
    }

    // Method to clear all parcels from the collection
    public void clearParcels() {
        parcels.clear();
    }

    // Method to enqueue customer data
    public void enqueueCustomerData(String[] customer) {
        customerQueue.offer(customer);
    }

    // Method to add combined data to the list
    public void addCombinedData(String[] data) {
        combinedDataList.add(data);
    }

    // Method to get combined data list
    public List<String[]> getCombinedDataList() {
        return combinedDataList;
    }

    public static void main(String[] args) {
        ParcelCollection collection = new ParcelCollection();

        // Read parcel data from file and store in the collection
        List<String[]> parcelData = readParcelFromFile("ParcelData.txt");
        for (String[] record : parcelData) {
            String id = record[0];
            int length = Integer.parseInt(record[3]);
            int width = Integer.parseInt(record[4]);
            int height = Integer.parseInt(record[5]);
            int noOfDays = Integer.parseInt(record[1]);
            int weight = Integer.parseInt(record[2]);
            Parcel parcel = new Parcel(id, length, width, height, noOfDays, weight);
            collection.addParcel(parcel);
        }

     // Read customer data from file and combine with parcel data if matching parcel id is found
        List<String[]> customerData = readCustomerDataFromFile("CustomerData.txt");
        for (String[] customer : customerData) {
            String customerParcelId = customer[2];
            Parcel parcel = collection.getParcel(customerParcelId);
            if (parcel != null) {
                String[] combinedData = new String[customer.length + 6]; // 6 fields from Parcel
                System.arraycopy(customer, 0, combinedData, 0, customer.length);
                combinedData[customer.length] = parcel.getId();
                combinedData[customer.length + 1] = String.valueOf(parcel.getLength());
                combinedData[customer.length + 2] = String.valueOf(parcel.getWidth());
                combinedData[customer.length + 3] = String.valueOf(parcel.getHeight());
                combinedData[customer.length + 4] = String.valueOf(parcel.getWeight());
                combinedData[customer.length + 5] = String.valueOf(parcel.getNoOfDays());
                collection.addCombinedData(combinedData);
            }
        }

        Parcel pcl = new Parcel();
        // Print combined data
        for (String[] combinedData : collection.getCombinedDataList()) {
            System.out.println("Combined Data:");
            System.out.println("Seq No: " + combinedData[0]);
            System.out.println("Full Names: " + combinedData[1]);
            System.out.println("Parcel Id: " + combinedData[2]);
            System.out.println("PhoneNumber: " + combinedData[3]);
            System.out.println("Email: " + combinedData[4]);
            System.out.println("Parcel Details:");
            System.out.println("Length: " + combinedData[6]);
            System.out.println("Width: " + combinedData[7]);
            System.out.println("Height: " + combinedData[8]);
            System.out.println("Weight: " + combinedData[9]);
            System.out.println("No of Days: " + combinedData[10]);
            
   	       // Display the output.
            System.out.println("Parcel Type : " + pcl.parcelType(pcl.chargeableWeight(Integer.parseInt(combinedData[6]), 
            		Integer.parseInt(combinedData[7]), Integer.parseInt(combinedData[8]), Integer.parseInt(combinedData[9]))) + "\n" +
   	       "Cost for Parcel is GBP : " + pcl.parcelFee(Integer.parseInt(combinedData[6]), Integer.parseInt(combinedData[7]),Integer.parseInt(combinedData[8]),Integer.parseInt(combinedData[9]),Integer.parseInt(combinedData[10]) )+ "\n"); 
            System.out.println("-------------------------------------");
            
        }
    }

    public static List<String[]> readParcelFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath))
                    .stream()
                    .map(line -> line.split("\t", -1)) // split each line by tab
                    .skip(1) // skip the header
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static List<String[]> readCustomerDataFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath))
                    .stream()
                    .map(line -> line.split("\t", -1)) // split each line by tab
                    .skip(1) // skip the header
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
