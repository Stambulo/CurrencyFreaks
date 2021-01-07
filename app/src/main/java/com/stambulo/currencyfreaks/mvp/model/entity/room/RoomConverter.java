package com.stambulo.currencyfreaks.mvp.model.entity.room;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class RoomConverter {
    @TypeConverter
    public static Map<String, String> ratesToMap(String value) {
        Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();
        return new Gson().fromJson(value, mapType);
    }

    @TypeConverter
    public static String mapToRates(Map<String, String> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
