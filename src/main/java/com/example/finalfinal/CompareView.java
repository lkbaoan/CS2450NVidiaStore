package com.example.finalfinal;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CompareView {
    public static VBox view;
//    public static TilePane spec;
    public static TilePane allView;
    public VBox specname;
//    public GridPane table;

    public  CompareView() {

        specname = new VBox(10,new Label("GPU Variant"), new Label("Architecture"),new Label("Foundry"),new Label("Process Size"),new Label("Transistors"),
                new Label("Density"),new Label("Die Size"),new Label("Cores"),new Label("Base Clock"),new Label("Boost Clock"),
                new Label("Memory Size"),new Label("Memory Type"),new Label("Memory Bus"),new Label("Bandwidth"),new Label("Suggested PSU"));
        specname.getStyleClass().add("compare-specname");

        Button compare = new Button();
        compare.getStyleClass().add("back-arrow");
        compare.setOnAction(event -> {
            Main.switchScene1();
        });




        allView = new TilePane();
        allView.getChildren().add(specname);
        allView.setAlignment(Pos.BASELINE_LEFT);
        HBox buttonPadding = new HBox(compare);
        buttonPadding.setPadding(new Insets(10));
        buttonPadding.setAlignment(Pos.CENTER);
        HBox a = new HBox(buttonPadding, specname, allView);
        a.setAlignment(Pos.CENTER);
        view = new VBox(a);
        view.setPadding(new Insets(250,100,250,150));
        view.setAlignment(Pos.BASELINE_CENTER);
//        buttonAndSpec.setStyle("-fx-border-color: blue"); //debug purpose
//        view.setStyle("-fx-border-color: blue"); //debug purpose
//        spec.setStyle("-fx-border-color: blue"); //debug purpose

        allView.setPrefColumns(7);
//        allView.setStyle("-fx-border-color: blue"); //debug purpose


    }
}

