package group05;

import java.util.HashMap;
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
//	    	ParcelCollection pc = new ParcelCollection();
//	    	pc.getParcelCount();
			Parcel pc = new Parcel();
			pc.parcelFee(65,50,35,21,3);
	    	
	    }
	    
	 }



