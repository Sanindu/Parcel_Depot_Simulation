package application;

import java.util.concurrent.BlockingQueue;

import javafx.application.Platform;
import javafx.scene.control.TitledPane;

import java.util.Random;

public class worker extends Thread {

    private BlockingQueue<String[]> customerQueue;
    private ParcelCollection parcelCollection;
    private int workerId;
    private double totalEarning;
    private int totalParcelProceed;
    private int processingSpeed = 500; // Default processing time in milliseconds
    private Random random = new Random();
    private TitledPane titledPane; // Add this field
    private ParcelController parcelController;
    private String[] currentCustomerData;

    // Modify the constructor to accept ParcelController reference
    public worker(int workerId, BlockingQueue<String[]> customerQueue, ParcelCollection parcelCollection, ParcelController parcelController) {
        this.workerId = workerId;
        this.customerQueue = customerQueue;
        this.parcelCollection = parcelCollection;
        this.totalEarning = 0.0;
        this.totalParcelProceed = 0;
        this.parcelController = parcelController; // Initialize ParcelController
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
                setCurrentCustomerData(customerData); // Update current customer data
                Thread.sleep(processingSpeed);

                String parcelId = customerData[2];
                Parcel parcel = parcelCollection.getParcel(parcelId);
                
             // Update UI with current processing customer data
                Platform.runLater(() -> parcelController.updateCurrentParcelLabel(customerData));


                if (parcel != null) {
                    // Process the parcel and calculate the fee
                    double fee = parcel.parcelFee(
                        parcel.getLength(), parcel.getWidth(), parcel.getHeight(),
                        parcel.getWeight(), parcel.getNoOfDays()
                    );

                    totalEarning += fee;
                    totalParcelProceed++;
                    
                    // Remove parcel from the collection 
                    parcelCollection.removeParcel(parcelId);

                

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
    
    public synchronized double getTotalEarnings() {
        return totalEarning;
    }
    
    // Add a method to update the current processing customer data
    public synchronized void setCurrentCustomerData(String[] customerData) {
        this.currentCustomerData = customerData;
    }

}