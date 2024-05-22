package application;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class ApplicationController {
	@FXML 
    private Button startButton;

    @FXML 
    private Label outputLabel;
    
    @FXML 
    private TextArea textArea;
    
    // This method is called when the FXML file is loaded
    public void initialize() 
    {
        // Perform any necessary initialization here.
    }
    
    // Event listener for the startButton
    public void startButtonListener() 
    { 
    	
		List<String[]> data = ParcelCollection.readParcelFromFile("ParcelData.txt");
		StringBuilder content = new StringBuilder();
        // Print the values of each record
        for (String[] record : data) {

            String id = record[0];
            int length = Integer.parseInt(record[3]);
            int width = Integer.parseInt(record[4]);
            int height = Integer.parseInt(record[5]);
            int noOfDays = Integer.parseInt(record[1]);
            int weight = Integer.parseInt(record[2]);
            Parcel pcl = new Parcel(id,length,width,height,noOfDays,weight);
            System.out.println("Parcel ID: " + id + "\n" + "Parcel Type : " + pcl.parcelType(pcl.chargeableWeight(length, width, height, weight)) + "\n" +
   	       "Cost for Parcel is GBP : " + pcl.(length, width,height,weight, noOfDays)+ "\n"); 
            System.out.println("-------------------------------------"); 
            
            
            
            content.append("Parcel ID: " + id + "\n" + "Parcel Type : " + pcl.parcelType(pcl.chargeableWeight(length, width, height, weight)) + "\n" +
   	       "Cost for Parcel is GBP : " + pcl.parcelFee(length, width,height,weight, noOfDays)+ "\n" + "-------------------------------------" + "\n"); 
   	       // Display the output
            textArea.setText(content.toString());
            try {
                // Sleep for one second (1000 milliseconds)
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
                e.printStackTrace();
            }
            
        }
    }
		

}
