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

    public static BorderPane borderPane = new BorderPane();
    public static HBox navBar = new HBox(10);
    public static MenuButton shop;
    public static View centerScene1 = new View();
    public static CompareView centerScene2 = new CompareView();
    public static SubScene center1, center2;
    public static RightPanel rightPanel = new RightPanel();
    @Override
    public void start(Stage stage) throws IOException {

        /*
         * Navigation bar that include Geforce name, News, Support, Shop Icon, and Account Icon
         */
        String[] navCaptions = new String[] {
                "NVidia", "News", "Support","Geforce", "Shop Icon", "Account Icon"
        };
        Hyperlink[] navLink = new Hyperlink[3];
        String[] urls = new String[] {
                "https://www.nvidia.com/en-us/",
                "https://www.nvidia.com/en-us/geforce/news/",
                "https://www.nvidia.com/en-us/geforce/support/"
        };

        Region navSeparate = new Region();
        HBox.setHgrow(navSeparate, Priority.ALWAYS);
        navBar.setAlignment(Pos.BASELINE_CENTER);
        navBar.setPadding(new Insets(5,10,0,5));
        for (int i =0; i < 3; i++) {
            final Hyperlink hpl = navLink[i] = new Hyperlink(navCaptions[i]);
            final String str = urls[i];
            hpl.setOnAction(event -> {
                getHostServices().showDocument(str);
            });
        }
        Label geforce = new Label(navCaptions[3]);
        geforce.getStyleClass().add("brand-label");
        geforce.onMouseClickedProperty().set(event -> {
                borderPane.setCenter(center1);
        });

        shop = new MenuButton();
        shop.getStyleClass().add("cart-button");
        Button account = new Button();
        account.setOnAction(event -> {
            getHostServices().showDocument("https://www.nvidia.com/en-us/account/");
        });
        account.getStyleClass().add("profile-button");
        navBar.getChildren().addAll(geforce, navLink[0], navLink[1], navLink[2], navSeparate, shop, account);
        /*-------------------------------------------------------------------------------------------------------------*/

        /*
         * Center Panel include filter and display items, as well as second panel to display compare.
         */
        center1 = new SubScene(centerScene1.allView, 1300, 900);
        center2 = new SubScene(centerScene2.view, 1300,900);

        /*
         * Left Panel: leave blank
         */
        Region leftPanel = new Region();
        leftPanel.setPrefSize(200,800);

        /*
         * Right Panel
         */



//        rightPanel.setStyle("-fx-border-color: blue"); //debug purpose
        /*
         * Set to border pane
         */
        borderPane.setTop(navBar);
        borderPane.setCenter(center1);
        borderPane.setLeft(leftPanel);
        borderPane.setRight(rightPanel.getRoot());
        Scene scene = new Scene(borderPane, 1800, 1000);
        scene.getStylesheets().add("styles.css");
        stage.setTitle("Geforce Nvidia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void switchScene2() {
        borderPane.setCenter(center2);
    }
    public static void switchScene1() {
        borderPane.setCenter(center1);
    }
}