package com.stambulo.currencyfreaks.mvp.model.entity.room;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.stambulo.currencyfreaks.CFreaksApplication;

@androidx.room.Database(entities = {RoomCurrencyRates.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static final String DB_NAME = "database.db";
    private static volatile Database INSTANCE;

    public abstract CurrencyDAO currencyDAO();

    public static Database getInstance(){
        Database refLocal = INSTANCE;

        if (refLocal == null){
            synchronized (Database.class){
                INSTANCE = refLocal;

                if (refLocal == null){
                    INSTANCE = refLocal = Room.databaseBuilder
                            (CFreaksApplication.INSTANCE, Database.class, DB_NAME)
//                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return refLocal;
    }
}
