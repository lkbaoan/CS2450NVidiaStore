package com.example.finalfinal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import com.example.finalfinal.Main;

public class RightPanel
{
    public static VBox rightSide = new VBox(10);
    public static VBox right= new VBox(10);

    public static Button compare = new Button("Compare");
    public static Button removeAllRight = new Button();
    public static HBox compareandRemove = new HBox(10, compare, removeAllRight);
    public RightPanel() {
//        right = new VBox();
//        right.setPrefColumns(1);
        rightSide.setPrefSize(300,800);
//        right.setAlignment(Pos.BASELINE_CENTER);
//        right.setHgap(5);
//        right.setVgap(5);
        compare.setOnAction(event -> {
            Main.switchScene2();
        });
        removeAllRight.setOnAction(event -> {
            right.getChildren().clear();
            CompareView.allView.getChildren().clear();
//            Item.added = false;
//            right.setVisible(false);
        });
        removeAllRight.getStyleClass().add("clear");
        compare.setAlignment(Pos.BASELINE_CENTER);
        compare.setPadding(new Insets(15,50,15,50));
        VBox.setMargin(compare, new Insets(10,50,10,70));
//        HBox compareandRemove = new HBox(10, compare, removeAllRight);
        compareandRemove.setAlignment(Pos.BASELINE_CENTER);

        rightSide.getChildren().addAll(compareandRemove, right);
        rightSide.setPadding(new Insets(30,5,10,5));
    }
    public  void addToRight(VBox item) {
        right.getChildren().add(item);
    }
    public VBox getRoot() {
        return rightSide;
    }
}
