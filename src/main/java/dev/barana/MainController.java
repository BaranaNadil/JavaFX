package dev.barana;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class MainController {

    @FXML
    private Circle myCurcle;

    private double x;
    private double y;

    public void up(ActionEvent e){
//        System.out.println("UP");
        myCurcle.setCenterY(y-=5);
    }

    public void down(ActionEvent e){
//        System.out.println("DOWN");
        myCurcle.setCenterY(y+=5);
    }

    public void left(ActionEvent e){
//        System.out.println("LEFT");
        myCurcle.setCenterX(x-=5);
    }

    public void right(ActionEvent e){
//        System.out.println("RIGHT");
        myCurcle.setCenterX(y+=5);
    }

}
