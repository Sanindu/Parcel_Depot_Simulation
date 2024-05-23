package application;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class worker extends Thread {

    private BlockingQueue<String[]> customerQueue;
    private ParcelCollection parcelCollection;
    private int workerId;
    private double totalEarning;
    private int totalParcelProceed;
    private int processingSpeed = 500; // Default processing time in milliseconds
    private Random random = new Random();

    public worker(int workerId, BlockingQueue<String[]> customerQueue, ParcelCollection parcelCollection) {
        this.workerId = workerId;
        this.customerQueue = customerQueue;
        this.parcelCollection = parcelCollection;
        this.totalEarning = 0.0;
        this.totalParcelProceed = 0;
    }

    // Synchronized method to change processing speed
    public synchronized void setProcessingSpeed(int speed) {
        this.processingSpeed = speed;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                String[] customerData = customerQueue.take();

                // Simulate processing time 
                Thread.sleep(processingSpeed);

                String parcelId = customerData[2];
                Parcel parcel = parcelCollection.getParcel(parcelId);
                

                if (parcel != null) {
                    int length = parcel.getLength();
                    int width = parcel.getWidth();
                    int height = parcel.getHeight();
                    int weight = parcel.getWeight();
                    int noOfDays = parcel.getNoOfDays();
                    double fee = parcel.parcelFee(length, width, height, weight, noOfDays);

                    totalEarning += fee;
                    totalParcelProceed++;

                    // Console output
                    System.out.println("worker " + workerId + " processed Customer: "
                            + customerData[1] + ", Parcel: " + parcelId
                            + ", Fee: £" + String.format("%.2f", fee));

                    // Simulate a break 
                    if (random.nextInt(10) == 0) { // 10% chance of taking a break
                        try {
                            System.out.println("worker " + workerId + " is taking a break...");
                            Thread.sleep(3000); // Break for 3 seconds (adjust as needed)
                        } catch (InterruptedException e) {
                            // Thread interrupted during break
                            System.out.println("worker " + workerId + " interrupted during break.");
                            Thread.currentThread().interrupt();
                        }
                    }

                } else {
                    System.out.println("worker " + workerId + ": Parcel not found - " + parcelId);
                }

            } catch (InterruptedException e) {
                // Thread interrupted (e.g., by the 'exit' command)
                System.out.println("worker " + workerId + " stopped.");
                Thread.currentThread().interrupt();
            }
        }
    }
}