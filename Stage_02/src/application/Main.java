package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.List;

public class Main extends Application {
	@Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("CSYM026 - Group 05");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

 

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

        // Create multiple worker threads (e.g., 2 workers)
        int numWorkers = 2;
        Worker[] workers = new Worker[numWorkers]; // Use 'Worker', not 'worker'
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new Worker(i + 1, customerQueue, parcelCollection);
            workers[i].start();
        }

        // Add customers to the queue 
        List<String[]> customerData = parcelCollection.readCustomerDataFromFile("CustomerData.txt");
        for (String[] customer : customerData) {
<<<<<<< Updated upstream
            customerQueue.add(customer);
        }

        // You might want to add a way to gracefully stop the worker threads here.
        // (For example, using Thread.interrupt() after a certain condition is met)
=======
            customerQueue.add(customer); 
        }  
        launch(args);
>>>>>>> Stashed changes
    }
}