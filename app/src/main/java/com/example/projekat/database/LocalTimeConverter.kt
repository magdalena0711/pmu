package com.example.projekat.database

import androidx.room.TypeConverter
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class LocalTimeConverter {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME

    @TypeConverter
    fun fromString(value: String?): LocalTime?{
        return value?.let { LocalTime.parse(it, formatter) }
    }

    @TypeConverter
    fun toString(localTime: LocalTime?): String?{
        return localTime?.format(formatter)
    }
}