package edu.utsa.cs3443.spring2026painterapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class HelloController {

    //enum for penSize
    private enum PenSize{
        SMALL(2),
        MEDIUM(4),
        LARGE(6);

        private int radius;

        PenSize(int radius){
            this.radius = radius;
        }

        public int getRadius(){
            return this.radius;
        }
    }

    //Instance variables for the Controller Class
    //to know what are the default values for the pensize and also pencolor
    //

    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLUE;



    //Method initialize in a controller
    @FXML
    private void initialize(){
        //seven radio buttons?!
        //How are these radio buttons connected to logical values in the controller?
        blackRadioButton.setUserData(Color.BLACK);
        blueRadioButton.setUserData(Color.BLUE);
        greenRadioButton.setUserData(Color.GREEN);
        redRadioButton.setUserData(Color.RED);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
        mediumRadioButton.setSelected(true);
        blueRadioButton.setSelected(true);
    }





    @FXML
    private RadioButton blackRadioButton;

    @FXML
    private RadioButton blueRadioButton;

    @FXML
    private Button clearButton;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton greenRadioButton;

    @FXML
    private RadioButton largeRadioButton;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton redRadioButton;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private RadioButton smallRadioButton;

    @FXML
    private Button undoButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        //what happens if the user selects one of the color radio buttons?
        brushColor = (Paint) colorToggleGroup.getSelectedToggle().getUserData();

    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        //instance variable we defined for size is called radius
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }

    @FXML
    void undoButtonPressed(ActionEvent event) {
        //how many children or how many circles are already added to my drawingPane?
        int count = drawingAreaPane.getChildren().size();
        //if there are already circles on the drawingpane then
        if(count > 0){
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }

}
