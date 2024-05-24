package application;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.concurrent.Task;
import java.util.Timer;
import java.util.TimerTask;

public class ParcelController {
    @FXML
    private TitledPane titlepane1;
    @FXML 
    private Button startButton;
    @FXML 
    private Label totalFee;
    @FXML 
    private Label promptLabel;

    private worker[] workers;
    
    @FXML
    private Label currentParcelLabel;
    
    @FXML
    private Button stopButton;
    
    @FXML
    private TableView<Item> table1;
    
    @FXML
    private TableColumn<Item, String> tableco1;
    
    @FXML
    private TableColumn<Item, Integer> tableco2;
    
    @FXML
    private TableColumn<Item, String> tableco3;
    
    @FXML
    private TableColumn<Item, Integer> tableco4;


    private ObservableList<Item> data;

    @FXML
    public void initialize() {
        // Set up the table columns
        tableco1.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableco2.setCellValueFactory(new PropertyValueFactory<>("weight"));
        tableco3.setCellValueFactory(new PropertyValueFactory<>("dimensions"));
        tableco4.setCellValueFactory(new PropertyValueFactory<>("deportDays"));

        // Initialize data list
        data = FXCollections.observableArrayList();
        
        // Populate data
        loadData();
        
        // Set data to the table
        table1.setItems(data);
    }

    private void loadData() {
        // Add the data entries to the observable list
        data.add(new Item("C01", 1, "25x25x25", 1));
        data.add(new Item("C02", 2, "25x30x10", 1));
        data.add(new Item("C03", 6, "50x50x20", 2));
        data.add(new Item("C04", 6, "55x45x15", 2));
        data.add(new Item("C05", 20, "60x45x25", 5));
        data.add(new Item("C06", 4, "47x40x10", 2));
        data.add(new Item("C07", 13, "55x45x10", 3));
        data.add(new Item("C08", 4, "46x40x10", 2));
        data.add(new Item("C09", 6, "51x40x20", 4));
        data.add(new Item("C10", 6, "50x43x35", 4));
        data.add(new Item("C11", 10, "47x36x15", 1));
        data.add(new Item("C12", 3, "48x48x5", 1));
        data.add(new Item("C13", 1, "20x20x5", 1));
        data.add(new Item("C14", 6, "50x40x50", 1));
        data.add(new Item("C15", 3, "56x46x16", 1));
        data.add(new Item("C16", 1, "10x20x10", 1));
        data.add(new Item("C17", 5, "52x37x7", 1));
        data.add(new Item("C18", 10, "47x37x3", 1));
        data.add(new Item("C19", 4, "48x36x2", 1));
        data.add(new Item("C20", 1, "5x5x10", 1));
        data.add(new Item("C21", 2, "10x5x5", 1));
        data.add(new Item("C22", 15, "51x41x5", 7));
        data.add(new Item("C23", 10, "60x40x20", 6));
        data.add(new Item("C24", 12, "45x45x2", 2));
        data.add(new Item("C25", 12, "60x36x12", 2));
        data.add(new Item("C26", 26, "130x50x10", 2));
        data.add(new Item("C27", 23, "70x70x10", 2));
        data.add(new Item("C28", 1, "2x4x5", 4));
        data.add(new Item("C29", 2, "20x5x5", 4));
        data.add(new Item("C30", 2, "10x20x20", 4));
        data.add(new Item("C31", 1, "5x5x5", 4));
        data.add(new Item("C32", 2, "20x10x5", 4));
        data.add(new Item("C33", 1, "30x30x10", 4));
        data.add(new Item("C34", 10, "46x40x6", 4));
        data.add(new Item("C35", 2, "10x20x5", 5));
        data.add(new Item("C36", 12, "50x40x12", 5));
        data.add(new Item("C37", 15, "52x38x12", 5));
        data.add(new Item("C38", 30, "200x100x150", 5));
        data.add(new Item("C39", 22, "210x120x100", 3));
        data.add(new Item("C40", 21, "80x100x50", 3));
        data.add(new Item("C41", 25, "150x150x20", 3));
        data.add(new Item("C42", 30, "250x100x40", 10));
        data.add(new Item("C43", 24, "70x50x5", 3));
        data.add(new Item("C44", 6, "60x45x20", 14));
        data.add(new Item("C45", 3, "46x36x10", 2));
        data.add(new Item("C46", 5, "52x40x10", 2));
        data.add(new Item("C47", 2, "40x20x20", 2));
        data.add(new Item("C48", 1, "35x25x5", 1));
        data.add(new Item("C49", 1, "30x25x5", 1));
        data.add(new Item("C50", 1, "20x35x15", 1));
    }
    // Event listener for the startButton
    public void startButtonListener() {
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
        workers = new worker[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new worker(i + 1, customerQueue, parcelCollection, this);
            workers[i].start();
        }

        // Add customers to the queue
        List<String[]> customerData = parcelCollection.readCustomerDataFromFile("CustomerData.txt");
        for (String[] customer : customerData) {
            customerQueue.add(customer);
            updateCurrentParcelLabel(customer);
        }

        // Start the total fee updater
        startTotalFeeUpdater();
    }
    
    // Modify the method to update the currentParcelLabel with the current processing customer data
    public void updateCurrentParcelLabel(String[] customerData) {
        StringBuilder labelBuilder = new StringBuilder();
        labelBuilder.append("Current Customer: ").append(customerData[1])
                    .append("\nParcel ID: ").append(customerData[2]);
        currentParcelLabel.setText(labelBuilder.toString());
    }
    
    private void startTotalFeeUpdater() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                double totalEarnings = 0.0;
                for (worker w : workers) {
                    totalEarnings += w.getTotalEarnings();
                }
                final String totalEarningsStr = String.format("£%.2f", totalEarnings);

                // Update the label on the JavaFX Application Thread
                Platform.runLater(() -> totalFee.setText(totalEarningsStr));
            }
        }, 0, 1000); // Update every second
    }
    
    // Event handler for the "Stop" button
  
    public void onStopButtonClicked() {
        // Interrupt all worker threads to stop processing
        for (worker worker : workers) {
            worker.interrupt();
        }
    }
}
