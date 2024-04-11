package group05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParcelCollection {
	    private Map<String, Parcel> parcels;

	    public ParcelCollection() {
	        this.parcels = new HashMap<>();
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

	public static void main (String[] args) {
		ParcelCollection pc = new ParcelCollection();
		List<String[]> data = readParcelFromFile("ParcelData.txt");
		System.out.println("Number of line in the file "+data.size());
		for(String[] parcel : data) {
			pc.addParcel(arrayToParcel(parcel));
		}
		System.out.println(String.format("Number of Parcels %s", pc.getParcelCount()));
		System.out.println(String.format("Get Parcel %s", pc.getParcel("C02")));
	}

	public static List<String[]> readParcelFromFile(String filePath) {
		try {
			return Files.readAllLines(Paths.get(filePath))
					.stream()
					.map(line ->
					{
						return line.split("\t", -1); // split each line by tab
					})
					.skip(1l) // i want to skip the text file header
					.toList();
		} catch (IOException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Parcel arrayToParcel(String[] data) {
		if(data == null || data.length == 0) {
			return null;
		}

		return new Parcel(data[0], Integer.parseInt(data[5]), Integer.parseInt(data[2]), Integer.parseInt(data[4]), Integer.parseInt(data[1]), Integer.parseInt(data[3]));
	}


 }



