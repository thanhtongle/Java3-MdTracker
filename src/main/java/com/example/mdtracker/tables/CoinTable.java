package com.example.mdtracker.tables;

import com.example.mdtracker.daos.CoinDAO;
import com.example.mdtracker.database.DBConst;
import com.example.mdtracker.database.Database;
import com.example.mdtracker.pojo.Coin;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CoinTable implements CoinDAO {
    Database db = Database.getInstance();
    ArrayList<Coin> coins;

    @Override
    public ArrayList<Coin> getAllCoins() {
        String query = "SELECT * FROM " + DBConst.TABLE_COIN;
        coins = new ArrayList<>();
        try {
            Statement getCoins = db.getConnection().createStatement();
            ResultSet resultSet = getCoins.executeQuery(query);
            /*
            * ID | NAME
            * 1 | PENNY
            * 2 | NICKEL
            * */
            while (resultSet.next()) {
                coins.add(new Coin(
                        resultSet.getInt(DBConst.COIN_COLUMN_ID),
                        resultSet.getString(DBConst.COIN_COLUMN_NAME)
                ));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return coins;
    }

    @Override
    public Coin getCoin(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_COIN + " WHERE " + DBConst.COIN_COLUMN_ID + " = " + id;
        try {
            Statement getCoin = db.getConnection().createStatement();
            ResultSet resultSet = getCoin.executeQuery(query);
            if(resultSet.next()) {
                return new Coin(
                        resultSet.getInt(DBConst.COIN_COLUMN_ID),
                        resultSet.getString(DBConst.COIN_COLUMN_NAME)
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
