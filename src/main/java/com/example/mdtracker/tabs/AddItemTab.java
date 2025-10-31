package com.example.mdtracker.tabs;

import com.example.mdtracker.pojo.Coin;
import com.example.mdtracker.tables.CoinTable;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddItemTab extends Tab {
    public AddItemTab() {
        this.setText("Add Tab");
        this.setClosable(false);
    }
    GridPane root = new GridPane();
    CoinTable coinTable = new CoinTable();
    Text name = new Text("Name: ");
    ComboBox<Coin> comboName = new ComboBox<Coin>(
            FXCollections.observableArrayList(coinTable.getAllCoins())
    );
}


