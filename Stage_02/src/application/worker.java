package application;

import java.util.concurrent.BlockingQueue;

public class worker extends Thread {

    private BlockingQueue<String[]> customerQueue;
    private ParcelCollection parcelCollection;
    private int workerId;
    private double totalEarning;
    private int totalParcelProceed;

    public worker(int workerId, BlockingQueue<String[]> customerQueue, ParcelCollection parcelCollection) {
        this.workerId = workerId;
        this.customerQueue = customerQueue;
        this.parcelCollection = parcelCollection;
        this.totalEarning = 0.0;
        this.totalParcelProceed = 0;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) { 
            try {
                String[] customerData = customerQueue.take(); 
                
                // Simulate processing time (for console, you might make it shorter)
                Thread.sleep(500);  // Sleep for 500 milliseconds (0.5 seconds)

                String parcelId = customerData[2];
                Parcel parcel = parcelCollection.getParcel(parcelId);

                if (parcel != null) {
                	int length = parcel.getLength();
                	int width =  parcel.getWidth();
                	int height =  parcel.getHeight();
                	int weight =  parcel.getWeight();
                	int noOfDays =  parcel.getNoOfDays();
                    double fee = parcel.parcelFee(length, width, height, weight, noOfDays);
                    totalEarning += fee;
                    totalParcelProceed++;

                    // Console output
                    System.out.println("Worker " + workerId + " processed Customer: " 
                                       + customerData[1] + ", Parcel: " + parcelId 
                                       + ", Fee: £" + String.format("%.2f", fee));
                    
                    // ... [You might remove the parcel from the collection here]
                } else {
                    System.out.println("Worker " + workerId + ": Parcel not found - " + parcelId); 
                } 

            } catch (InterruptedException e) {
                System.out.println("Worker " + workerId + " stopped.");
                Thread.currentThread().interrupt(); 
            }
        }
    }
}