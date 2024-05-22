package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	   public void start(Stage stage) throws Exception
	   {  
	      // Load the FXML file.
	      Parent parent = FXMLLoader.load(
	               getClass().getResource("Application.fxml")); 
	      
	      // Build the scene graph.
	      Scene scene = new Scene(parent); 
	      
	      // Display our window, using the scene graph.
	      stage.setTitle("Deport Simulation -  Group 05"); 
	      stage.setScene(scene);
	      stage.show(); 
	   }
	   
	   public static void main(String[] args)
	   {
	      // Launch the application.
	      launch(args);
	   }
}
