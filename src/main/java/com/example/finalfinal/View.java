package com.example.finalfinal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Predicate;

public class View {
    public VBox allView;
    public Item[] item;

    public View() {
        allView = new VBox(5);
        TopPanel filter = new TopPanel();
        TilePane tile = new TilePane();

        /**
         * Product and key feature
         */
        item = new Item[8];
        item[0] = new Item("GV-N4080EAGLE-16GD.png", "Gigabyte GV-N4080EAGLE-16GD graphics card", 1149.99);
        item[1] = new Item("GV-N4090GAMING OC-24GD.png", "Gigabyte GeForce RTX 4090 GAMING OC 24G", 1699.99);
        item[2] = new Item("TUF-RTX4090-O24G-GAMING.png", "ASUS TUF-RTX4090-O24G-GAMING", 1799.99);
        item[3] = new Item("GeForce-RTX4080-Back.png", "Nvidia GeForce RTX 4080", 1199.00);
        item[4] = new Item("VCG409024TFXXPB1.png", "PNY GeForce RTX 4090 Gaming VERTO", 1609.99);
        item[5] = new Item("SUPRIM-X.png", "MSI GeForce RTX 4090 SUPRIM X 24G", 1749.99);
        item[6] = new Item("GIGABYTE-GeForce-RTX-4070-AERO-OC-12G.png", "Gigabyte GeForce RTX 4070 Ti AERO OC 12G", 899.99);
        item[7] = new Item("VCG408016TFXXPB1-O_US.png", "PNY GeForce RTX 4080 Gaming VERTO", 1199.99);

        String[] keyfeature = {
                "Cooling System:Active,Boost Clock Speed:2505 MHz,GPU Memory Size:16 GB",
                "Cooling System:Active,Boost Clock Speed:--,GPU Memory Size:24 GB",
                "Cooling System:Axial-tech,Boost Clock Speed:2565 MHz,GPU Memory Size:24 GB",
                "Cooling System: Fan,Boost Clock Speed: 2.51 GHz,GPU Memory Size: 16 GB",
                "Cooling System:Triple Fan,Boost Clock Speed:2520 MHz,GPU Memory Size:24 GB",
                "Cooling System:TRI-FROZR 3S,Boost Clock Speed:--,GPU Memory Size:24 GB",
                "Cooling System:GDDR6X,Boost Clock Speed:2310 MHz,GPU Memory Size:12 GB",
                "Cooling System:Active,Boost Clock Speed:2510 MHz,GPU Memory Size:16 GB",
        };

        for (int i = 0; i<8;i++) {
            String[] split = keyfeature[i].split(",",3);

            item[i].setKeyfeature(split);
            tile.getChildren().add(item[i].getBasicInfo());
        }
        String[] fullSpec = {
                "AD103-300-A1,Ada Lovelace,TSMC,5 nm,45900 million,121.1M / mm²,379 mm²,9728,2205 MHz,2505 MHz,16 GB,GDDR6X,256 bit,716.8 GB/s,700 W",
                "AD102-300-A1,Ada Lovelace,TSMC,5 nm,76300 million,125.5M / mm²,608 mm²,16384,2235 MHz,2535 MHz,24 GB,GDDR6X,384 bit,1008 GB/s,850 W",
                "AD102-300-A1,Ada Lovelace,TSMC,5 nm,76300 million,125.5M / mm²,608 mm²,16384,2235 MHz,2565 MHz,24 GB,GDDR6X,384 bit,1008 GB/s,850 W",
                "AD103-300-A1,Ada Lovelace,TSMC,5 nm,45900 million,121.1M / mm²,379 mm²,9728,2205 MHz,2505 MHz,16 GB,GDDR6X,256 bit,716.8 GB/s,700 W",
                "AD102-300-A1,Ada Lovelace,TSMC,5 nm,76300 million,125.5M / mm²,608 mm²,16384,2235 MHz,2520 MHz,24 GB,GDDR6X,384 bit,1008 GB/s,850 W",
                "AD102-300-A1,Ada Lovelace,TSMC,5 nm,76300 million,125.5M / mm²,608 mm²,16384,2235 MHz,2625 MHz,24 GB,GDDR6X,384 bit,1008 GB/s,850 W",
                "AD104-400-A1,Ada Lovelace,TSMC,5 nm,35800 million,121.4M / mm²,295 mm²,7680,2310 MHz,2610 MHz,12 GB,GDDR6X,192 bit,504.2 GB/s,600 W",
                "AD102-300-A1,Ada Lovelace,TSMC,5 nm,76300 million,125.5M / mm²,608 mm²,16384,2235 MHz,2520 MHz,24 GB,GDDR6X,384 bit,1008 GB/s,850 W",

        };
        for (int i = 0; i< 8; i++) {
            String[] split = fullSpec[i].split(",");
            item[i].setFullspec(split);
        }

        /**
         * Filter
         */




        tile.setAlignment(Pos.BASELINE_CENTER);
        tile.setHgap(5);
        tile.setVgap(5);

        Region centerBlank = new Region();
        VBox.setVgrow(centerBlank, Priority.ALWAYS);
        allView.getChildren().addAll(filter.getRoot(),centerBlank, tile);
    }

}
