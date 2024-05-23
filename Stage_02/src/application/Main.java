package application;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Create the shared data structures
        BlockingQueue<String[]> customerQueue = new LinkedBlockingQueue<>();
        ParcelCollection parcelCollection = new ParcelCollection();

        // Populate parcelCollection from the file
        List<String[]> parcelData = parcelCollection.readParcelFromFile("ParcelData.txt");
        for (String[] record : parcelData) {
            String id = record[0];
            int length = Integer.parseInt(record[3]);
            int width = Integer.parseInt(record[4]);
            int height = Integer.parseInt(record[5]);
            int noOfDays = Integer.parseInt(record[1]);
            int weight = Integer.parseInt(record[2]);
            Parcel parcel = new Parcel(id, length, width, height, noOfDays, weight);
            parcelCollection.addParcel(parcel);
        }

        // Create and start worker threads (e.g., 2 workers)
        worker worker1 = new worker(1, customerQueue, parcelCollection);
        worker worker2 = new worker(2, customerQueue, parcelCollection);
        worker1.start();
        worker2.start();

        // Add customers to the queue (you'll need to read this from your customer data file)
        List<String[]> customerData = parcelCollection.readCustomerDataFromFile("CustomerData.txt");
        for (String[] customer : customerData) {
            customerQueue.add(customer); 
        }        
    }
}