package com.example.finalfinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    final static String[] navCaptions = new String[] {
             "NVidia", "News", "Support","Geforce", "Shop Icon", "Account Icon"
    };
    final Hyperlink[] navLink = new Hyperlink[3];
    final static String[] urls = new String[] {
            "https://www.nvidia.com/en-us/",
            "https://www.nvidia.com/en-us/geforce/news/",
            "https://www.nvidia.com/en-us/geforce/support/"
    };
    public static BorderPane borderPane = new BorderPane();
    @Override
    public void start(Stage stage) throws IOException {

        /**
         * Navigation bar that include Geforce name, News, Support, Shop Icon, and Account Icon
         */
        HBox navBar = new HBox(10);
//        navBar.setStyle("-fx-border-color: blue"); //debug purpose
        Region navSeparate = new Region();
        HBox.setHgrow(navSeparate, Priority.ALWAYS);
        navBar.setAlignment(Pos.BASELINE_CENTER);
        navBar.setPadding(new Insets(5,10,0,5));
        for (int i =0; i < 3; i++) {
            navLink[i] = new Hyperlink(navCaptions[i]);
        }
        Label geforce = new Label(navCaptions[3]);
        geforce.getStyleClass().add("brand-label");
        MenuButton shop = new MenuButton();
        shop.getStyleClass().add("cart-button");
        Button account = new Button();
        account.getStyleClass().add("profile-button");
        navBar.getChildren().addAll(geforce, navLink[0], navLink[1], navLink[2], navSeparate, shop, account);


        /**
         * Center Panel include filter and display items, as well as second panel to display compare.
         */
        View centerView = new View();
        SubScene center1 = new SubScene(centerView.allView, 1300, 900);

        Button toCenter1 = new Button();
        toCenter1.getStyleClass().add("back-arrow");
        toCenter1.setOnAction(event -> {
            borderPane.setCenter(center1);
        });
        CompareView compareView = new CompareView(toCenter1);
        SubScene center2 = new SubScene(compareView.allView, 1300,900);


        /**
         * Left Panel: leave blank
         */


        Region leftPanel = new Region();
        leftPanel.setPrefSize(200,800);
//        leftPanel.setStyle("-fx-border-color: blue"); //debug purpose
        /**
         * Right Panel
         * TODO
         */

//        Region rightPanel = new Region();
//        rightPanel.setPrefSize(300,800);
        RightPanel rightPanel = new RightPanel();

//        VBox rightPanel = new VBox(10);
//        rightPanel.setPrefHeight(800);
//        rightPanel.setPrefWidth(300);


        Button compare = new Button("Compare");
        compare.setOnAction(event -> {
            borderPane.setCenter(center2);

        });
        compare.setAlignment(Pos.CENTER);
        compare.setPrefSize(100,30);
//        rightPanel.getChildren().add(compare);
        VBox.setMargin(compare, new Insets(50,100,20,100));

//        rightPanel.getChildren().add(new RightPanel().getRoot());
//        for (int i = 0; i< 8; i++) {
//            centerView.item[i].comapre.setOnAction(event -> {
//                rightPanel.getChildren().add(centerView.item[1].getCompare());
//            });
//        }
//        centerView.item[0].comapre.setOnAction(event -> {
//
//            compareView.allView.getChildren().add(centerView.item[0].getFullspec());
//            rightPanel.getChildren().add(centerView.item[0].getCompare());
//        });
//        centerView.item[1].comapre.setOnAction(event -> {
//
//            compareView.allView.getChildren().add(centerView.item[1].getFullspec());
//            rightPanel.getChildren().add(centerView.item[1].getCompare());
//        });
//        centerView.item[2].comapre.setOnAction(event -> {
//
//            compareView.allView.getChildren().add(centerView.item[2].getFullspec());
//            rightPanel.getChildren().add(centerView.item[2].getCompare());
//        });
//        centerView.item[3].comapre.setOnAction(event -> {
//
//            compareView.allView.getChildren().add(centerView.item[3].getFullspec());
//            rightPanel.getChildren().add(centerView.item[3].getCompare());
//        });
//        centerView.item[4].comapre.setOnAction(event -> {
//
//            compareView.allView.getChildren().add(centerView.item[4].getFullspec());
//            rightPanel.getChildren().add(centerView.item[4].getCompare());
//        });
//        centerView.item[5].comapre.setOnAction(event -> {
//
//            compareView.allView.getChildren().add(centerView.item[5].getFullspec());
//            rightPanel.getChildren().add(centerView.item[5].getCompare());
//        });
//        centerView.item[6].comapre.setOnAction(event -> {
//            compareView.allView.getChildren().add(centerView.item[6].getFullspec());
//            rightPanel.getChildren().add(centerView.item[6].getCompare());
//        });
//        centerView.item[7].comapre.setOnAction(event -> {
//
//            compareView.allView.getChildren().add(centerView.item[7].getFullspec());
//            rightPanel.getChildren().add(centerView.item[7].getCompare());
//        });




//        rightPanel.setStyle("-fx-border-color: blue"); //debug purpose
        /**
         * Set to border pane
         */
        borderPane.setTop(navBar);
        borderPane.setCenter(center1);
        borderPane.setLeft(leftPanel);
        borderPane.setRight(rightPanel);
        Scene scene = new Scene(borderPane, 1800, 1000);
        scene.getStylesheets().add("styles.css");
        stage.setTitle("Geforce Nvidia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}