package com.example.finalfinal;

import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

public class ItemBox {
    public GridPane root;
    public VBox featureBox;
    private Button compare;
    private boolean added;

    public Node getRoot() {
        return root;
    }
    public ItemBox(String imageName, String product, double price) {

        ImageView img = new ImageView(new Image(String.format("file:src/main/resources/img/%s", imageName)));
        img.setPreserveRatio(true);
        img.setFitHeight(100);

        Label productName = new Label(product);
        productName.getStyleClass().add("product-name");
        productName.setWrapText(true);
        Label cost = new Label(String.format("$%,.2f", price));

        Label feature1 = new Label("Place holder");
        Label feature2 = new Label("Place holder");
        Label feature3 = new Label("Place holder");

        featureBox = new VBox(5, feature1, feature2, feature3);

        compare = new Button("Compare");
        compare.setOnAction(event -> {
            added = true;
        });
        Button aaa = new Button("aaa");
        aaa.setVisible(false);
        root = new GridPane();
        root.add(img, 0, 0);
        root.add(productName, 0, 1);
        root.add(cost, 0, 2);
        root.add(featureBox, 0, 3);
//        root.add(compare, 0, 4);
//        root.add(aaa, 0,5);
//        root.add(displayFeature, 1, 3);

//        displayFeature.setOnAction(event-> {
//            setCollapsed();
//        });

        GridPane.setFillWidth(root, true);
        GridPane.setHalignment(img, HPos.CENTER);
        GridPane.setHalignment(cost, HPos.RIGHT);
        GridPane.setHalignment(featureBox, HPos.LEFT);

        root.setPrefSize(250, 250);
        root.getStyleClass().add("item-box");
        root.setAlignment(Pos.BASELINE_CENTER);

        compare.setVisible(false);
        root.getStyleClass().add("scale-item");
        root.hoverProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {

            if (newValue) {
                root.add(compare, 0, 4);
                root.add(aaa, 0,5);
                aaa.setVisible(true);
                compare.setVisible(true);
            } else {
                root.getChildren().remove(compare);
                root.getChildren().remove(aaa);
//                aaa.setVisible(false);
                compare.setVisible(false);
            }
        });
    }
    public boolean isAddedToCompare() {
        return added;
    }
    public void removeCompare() {
        added = false;
    }

//    public void setCollapsed() {
//        if (collapsed) {
//            displayFeature.setText("v");
////            featureBox.getChildren().removeAll();
//            featureBox.setVisible(false);
//            collapsed = true;
//        } else {
//            displayFeature.setText("^");
////            featureBox.getChildren().addAll();
//            featureBox.setVisible(true);
//            collapsed = false;
//        }
//
//    }
}
