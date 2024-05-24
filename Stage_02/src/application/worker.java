package application;

import java.util.concurrent.BlockingQueue;
import java.util.Random;

public class Worker extends Thread {

    private BlockingQueue<String[]> customerQueue;
    private ParcelCollection parcelCollection;
    private int workerId;
    private double totalEarning;
    private int totalParcelProceed;
    private int processingSpeed = 500; // Default processing time in milliseconds
    private Random random = new Random();

    public Worker(int workerId, BlockingQueue<String[]> customerQueue, ParcelCollection parcelCollection) {
        this.workerId = workerId;
        this.customerQueue = customerQueue;
        this.parcelCollection = parcelCollection;
        this.totalEarning = 0.0;
        this.totalParcelProceed = 0;
    }

    // Synchronized method to change processing speed (if needed)
    public synchronized void setProcessingSpeed(int speed) {
        this.processingSpeed = speed;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                String[] customerData = customerQueue.take();
                Thread.sleep(processingSpeed);

                String parcelId = customerData[2];
                Parcel parcel = parcelCollection.getParcel(parcelId);

                if (parcel != null) {
                    // Process the parcel and calculate the fee
                    double fee = parcel.parcelFee(
                        parcel.getLength(), parcel.getWidth(), parcel.getHeight(),
                        parcel.getWeight(), parcel.getNoOfDays()
                    );

                    totalEarning += fee;
                    totalParcelProceed++;

                

                    // Console output
                    System.out.println("Worker " + workerId + " processed Customer: "
                            + customerData[1] + ", Parcel: " + parcelId
                            + ", Fee: £" + String.format("%.2f", fee) 
                            + ", Total Earnings: £" + String.format("%.2f", totalEarning));

                    // Simulate a break (if needed)
                    if (random.nextInt(10) == 0) { 
                        System.out.println("Worker " + workerId + " is taking a break...");
                        Thread.sleep(3000); 
                    }

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