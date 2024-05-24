module HelloWorld {
	requires javafx.controls;
	requires javafx.fxml;
	

	
	opens application to javafx.base, javafx.fxml;
	
	exports application;
	
}
