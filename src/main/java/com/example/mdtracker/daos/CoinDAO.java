package com.example.mdtracker.daos;

import com.example.mdtracker.pojo.Coin;

import java.util.ArrayList;

public interface CoinDAO {
    public ArrayList<Coin> getAllCoins();
    public Coin getCoin(int id);
}
