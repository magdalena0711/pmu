package com.example.projekat.database

import androidx.room.TypeConverter
import org.json.JSONObject


class JSONObjectConverter {
    @TypeConverter
    fun fromJSONObject(jsonObject: JSONObject?): String?{
        return jsonObject?.toString()
    }

    @TypeConverter
    fun toJSONObject(jsonString: String?): JSONObject?{
        return jsonString?.let {
            try {
                JSONObject(it)
            }catch (e: Exception){
                e.printStackTrace()
                null
            }
        }
    }
}