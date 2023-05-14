package com.example.finalfinal;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;


public class FilterItem {
    public HBox root;
    public CheckBox checkBox;
    public String name;

    public Node getRoot() {
        return root;
    }

    public FilterItem(String name, int count) {
        checkBox = new CheckBox();
        checkBox.setPrefWidth(10);
        checkBox.setPrefHeight(10);
        this.name = name;
        Label label = new Label(name);
        Label countLabel = new Label("(" + count + ")");

        label.setTextFill(Color.WHITE);
        countLabel.setTextFill(Color.WHITE);

        root = new HBox(
                5,
                checkBox,
                label,
                countLabel
        );
        label.setPrefWidth(150);
        root.setPrefWidth(200);

        checkBox.setOnAction(event -> {
            Item[] a = View.getItem();

            for (int i = 0; i< a.length; i++) {
                if (checkBox.isSelected()) {

                    if (!a[i].getName().contains(name)) {
                        View.tile.getChildren().get(i).setVisible(false);
                        View.tile.getChildren().get(i).setManaged(false);
                    }
                } else {
                    View.tile.getChildren().get(i).setVisible(true);
                    View.tile.getChildren().get(i).setManaged(true);
                }
            }

        });
    }
    public CheckBox getCheckBox() {
        return checkBox;
    }
    public String getName() {
        return name;
    }
}