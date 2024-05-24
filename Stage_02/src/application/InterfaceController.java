package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;

public class InterfaceController {
    
    @FXML
    private Button startButton;
    
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

    @FXML
    private Label totalFee;

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

    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        // Handle start button action
        System.out.println("Start button pressed");
    }

    @FXML
    private void handleStopButtonAction(ActionEvent event) {
        // Handle stop button action
        System.out.println("Stop button pressed");
    }
}
