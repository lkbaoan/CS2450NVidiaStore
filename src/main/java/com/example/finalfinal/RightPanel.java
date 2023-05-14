package com.example.finalfinal;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import com.example.finalfinal.Main;
public class RightPanel
{
    public static VBox right= new VBox();
    public static Button compare = new Button("Compare");
    public RightPanel() {
//        right = new VBox();
//        right.setPrefColumns(1);
        right.setMinSize(300,800);
//        right.setAlignment(Pos.BASELINE_CENTER);
//        right.setHgap(5);
//        right.setVgap(5);
        compare.setOnAction(event -> {
            Main.borderPane.setCenter(center2);

        });
    }
    public  void addToRight(VBox item) {
        right.getChildren().add(item);
    }
    public VBox getRoot() {
        return right;
    }
}
