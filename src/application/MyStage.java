package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;

public class MyStage extends AnchorPane {
	
	@FXML private AnchorPane rootPane;
	@FXML private BorderPane borderPane;

    public MyStage() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MyStage.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    @FXML
    public void initialize() {
    	/*CubicCurve cc = new CubicCurve(100, 200, 150, 220, 250, 240, 300, 250);*/
    	CubicCurve cc = new CubicCurve();
    	/*cc.setStroke(Color.BLUE);
    	cc.setFill(null);*/
    	
    	// membuat circle
    	Circle circle1 = new Circle(100, 150, 10, Color.AQUA);
    	Circle circle2 = new Circle(300, 150, 10, Color.AQUA);
    	
    	// membuat cubic curve berdasarkan letak circle
    	cc.setStartX(circle1.getCenterX());
    	cc.setStartY(circle1.getCenterY());
    	cc.setEndX(circle2.getCenterX());
    	cc.setEndY(circle2.getCenterY());
    	
    	cc.setControlX1(circle1.getCenterX());
    	cc.setControlY1(circle1.getCenterY());
    	cc.setControlX2(circle2.getCenterX());
    	cc.setControlY2(circle2.getCenterY());    	
    	
    	cc.setStroke(Color.BLUE);
    	cc.setFill(null);
    	
    	rootPane.getChildren().addAll(circle1, circle2, cc);
    	
    }
    
	@FXML
	void mouseEnter(MouseEvent event) {
		
		System.out.println("Root: getSceneX: " + event.getSceneX());
		System.out.println("Root: getSceneY: " + event.getSceneY());
		System.out.println("Root: getX: " + event.getX());
		System.out.println("Root: getY: " + event.getY());
	}
	
	@FXML
    void borderMouseEnter(MouseEvent event) {
		System.out.println("Border: getSceneX: " + event.getSceneX());
		System.out.println("Border: getSceneY: " + event.getSceneY());
		System.out.println("Border: getX: " + event.getX());
		System.out.println("Border: getY: " + event.getY());
	}
	
	@FXML
	void mouseDragEnter(MouseDragEvent event) {
	
	}
}
