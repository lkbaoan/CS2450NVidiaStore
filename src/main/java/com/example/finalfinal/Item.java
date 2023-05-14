package com.example.finalfinal;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import com.example.finalfinal.RightPanel;
public class Item {
    private String type;
    private final ImageView img;
    private final Label name;
    private final Label price;
    private VBox keyfeature;
    private VBox fullspec;
    public Button compare, buy;
    private  GridPane grid;
    private HBox hbox;

    public boolean compareTo;
    public boolean buyTo;
    public VBox boxbox;
    /**
     * Copy Node
     */
    private ImageView copyImg;
    private Label copyName;

    public Item(String img, String name, double price) {
        this.img = new ImageView(new Image(String.format("file:src/main/resources/img/%s", img)));

        this.name = new Label(name);
        this.price = new Label(String.format("$%.2f", price));
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
        buyTo =false;
        compare = new Button("Compare");
        buy = new Button("Buy");

        compare.setOnAction(event -> {
            RightPanel.right.getChildren().add(getCompare());
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
//    public void setFullspec(String Codename,String Architecture,String Pipelines,String TMUs,String ROPs,String RaytracingCores,String TensorAICores,String CoreSpeed,
//                            String TheoreticalPerformance,String Cache,String MemorySpeed,String MemoryBusWidth,String MemoryType,String MaxAmountofMemory,String SharedMemory,
//                            String MemoryBandwidth,String API,String PowerConsumption,String TransistorCount,String DieSize,String technology,String Displays) {
//        fullspec = new VBox(5);
//        fullspec.getChildren().addAll(new Label(Codename), new Label(Architecture), new Label(Pipelines), new Label(TMUs),
//                new Label(ROPs), new Label(RaytracingCores), new Label(TensorAICores), new Label(CoreSpeed), new Label(TheoreticalPerformance), new Label(Cache),
//                new Label(MemorySpeed), new Label(MemoryBusWidth), new Label(MemoryType), new Label(MaxAmountofMemory), new Label(SharedMemory), new Label(MemoryBandwidth),
//                new Label(API), new Label(PowerConsumption), new Label(TransistorCount), new Label(DieSize), new Label(technology), new Label(Displays));
//    }
    public void setFullspec(String[] full) {
        fullspec = new VBox(10);
        for(int i =0; i< 15; i++) {
            Label toSpec =new Label(full[i]);

            fullspec.getChildren().add(toSpec);
        }
    }
    public VBox getFullspec() {

        boxbox.getChildren().add(fullspec);
        boxbox.getStyleClass().add("compare-spec");
        return boxbox;
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
        hbox = new HBox(5);
       VBox copy = new VBox(5, copyImg, copyName);
       Button hide = new Button("[X]");
       hide.setOnAction(event -> {
           hbox.setVisible(false);
           hbox.setManaged(false);
       });
       hbox.getChildren().addAll(copy, hide);
        hbox.setPadding(new Insets(0,5,5,0));
        hbox.getStyleClass().add("item-box");
        return  hbox;
    }

}
