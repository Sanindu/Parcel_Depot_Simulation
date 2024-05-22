module HelloWorld {
	requires javafx.controls;
	requires javafx.fxml;
	requires jdk.incubator.vector;
	requires junit;

	
	opens application to javafx.graphics, javafx.fxml;
	opens kilometerConverter to javafx.graphics, javafx.fxml;
}
