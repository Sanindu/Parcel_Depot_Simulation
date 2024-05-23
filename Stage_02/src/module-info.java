module Stag_02{
	requires javafx.controls;
	requires javafx.fxml;
	requires jdk.incubator.vector;
	

	
	opens application to javafx.graphics, javafx.fxml;
}
