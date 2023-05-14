package com.example.finalfinal;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class CompareView {
    public TilePane allView;
    public VBox specname;
    public GridPane table;

    public  CompareView(Button back) {
        table = new GridPane();
        specname = new VBox(10,new Label("GPU Variant"), new Label("Architecture"),new Label("Foundry"),new Label("Process Size"),new Label("Transistors"),
                new Label("Density"),new Label("Die Size"),new Label("Cores"),new Label("Base Clock"),new Label("Boost Clock"),
                new Label("Memory Size"),new Label("Memory Type"),new Label("Memory Bus"),new Label("Bandwidth"),new Label("Suggested PSU"));
        specname.getStyleClass().add("compare-specname");
        table.add(specname,0,1);



        allView = new TilePane();
        allView.getChildren().add(back);
        allView.setMinSize(1300,900);

        allView.getChildren().add(specname);
        allView.setAlignment(Pos.CENTER);


    }
    public void addBackButton(Button button) {



    }
//    public void addToTable(VBox product) {
//        table.add();
//    }
}

