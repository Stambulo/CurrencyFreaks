package com.stambulo.currencyfreaks.mvp.model.entity.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CurrencyDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RoomCurrencyRates rates);

    @Query("SELECT * FROM RoomCurrencyRates")
    RoomCurrencyRates getLastRates();
}
