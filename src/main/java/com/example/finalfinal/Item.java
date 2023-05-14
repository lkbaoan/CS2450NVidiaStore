package com.example.finalfinal;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import com.example.finalfinal.RightPanel;
public class Item {
    private String type;
    private  ImageView img;
    private  Label name;
    private  Label price;
    private VBox keyfeature;
    private VBox fullspec;
    public Button compare, buy;
    private  GridPane grid;
    private HBox hbox;

    public boolean compareTo;
    public boolean buyTo;
    public VBox boxbox;
    public HBox buyContent;
    /**
     * Copy Node
     */
    public String n;
    private ImageView copyImg;
    private Label copyName;
    public static boolean added;


    public Item(String img, String name, double price) {
        this.img = new ImageView(new Image(String.format("file:src/main/resources/img/%s", img)));
        n =name;
        this.name = new Label(name);
        this.price = new Label(String.format("$%.2f", price));
        added = false;
        type = "graphic card";
        grid = new GridPane();

        boxbox =  new VBox();
        copyImg = new ImageView(new Image(String.format("file:src/main/resources/img/%s", img)));
        copyName = new Label(name);
        copyImg.setPreserveRatio(true);
        copyImg.setFitHeight(100);
        copyName.getStyleClass().add("product-name");
        copyName.setWrapText(true);
        this.img.setPreserveRatio(true);
        this.img.setFitHeight(100);
        this.name.getStyleClass().add("product-name");
        this.name.setWrapText(true);
        compareTo = false;
        buyTo = false;
        compare = new Button("Compare");
        buy = new Button("Buy");



        compare.setOnAction(event -> {
            if (!added) {
                RightPanel.right.getChildren().add(getCompare());
                CompareView.allView.getChildren().add(getFullspec());
            } else {
                System.out.println("Already Added");
            }
        });

        buy.setOnAction(event -> {
            Main.shop.getItems().add(new CustomMenuItem(buyContent));
        });
    }
    public String getType() {
        return type;
    }
    public void setKeyfeature(String[] f) {
        HBox[] h = new HBox[3];
        Button[] nothing = new Button[3];
        for (int i = 0;i < 3;i++) {
            h[i] = new HBox(5);
            nothing[i] = new Button();
            h[i].getChildren().addAll(nothing[i],new Label(f[i]));
            h[i].setAlignment(Pos.CENTER_LEFT);
            nothing[i].getStyleClass().add("arrow-feature");
        }
        keyfeature = new VBox(5, h[0], h[1], h[2]);
    }

    public VBox getKeyfeature() {
        return keyfeature;
    }

    public void setFullspec(String[] full) {
        fullspec = new VBox(10);
        for(int i =0; i< 15; i++) {
            Label toSpec =new Label(full[i]);

            fullspec.getChildren().add(toSpec);
        }
    }
    public VBox getFullspec() {
        VBox v = new VBox(fullspec);
//        boxbox.getChildren().add(fullspec);
        v.getStyleClass().add("compare-spec");
        return v;
    }
    public GridPane getBasicInfo() {

        compare.setPadding(new Insets(5));
        buy.setPadding(new Insets(5));
        grid.add(img, 0,0,2,1);
        grid.add(name, 0,1,2,1);
        grid.add(price, 0,2,2,1);
        grid.add(getKeyfeature(), 0,3,2,1);
        grid.add(compare, 0,4);
        grid.add(buy,1,4);

        grid.getStyleClass().add("item-box");
        grid.setVgap(3);
        grid.setPrefSize(300,250);
        grid.setAlignment(Pos.BASELINE_CENTER);
        GridPane.setFillWidth(grid, true);
        GridPane.setHalignment(img, HPos.CENTER);
        GridPane.setHalignment(price, HPos.RIGHT);
        GridPane.setHalignment(getKeyfeature(), HPos.LEFT);
        GridPane.setHalignment(compare, HPos.LEFT);
        GridPane.setHalignment(buy, HPos.RIGHT);

        compare.setVisible(false);
        buy.setVisible(false);
        grid.setOnMouseEntered(event -> {
            compare.setVisible(true);
            buy.setVisible(true);
        });
        grid.setOnMouseExited(event -> {
            compare.setVisible(false);
            buy.setVisible(false);
        });


        return  grid;
    }
    public HBox getCompare() {
        HBox h = new HBox(5);
        VBox copy = new VBox(5, copyImg, copyName);
        h.getChildren().add(copy);
//        hbox.getChildren().addAll(copy, hide);
        h.setPadding(new Insets(0,5,5,0));
        h.getStyleClass().add("item-box");
        return  h;
    }
    public void changeAddState() {
        added = !added;
    }
    public String getName() {
        return name.getText();
    }
}
