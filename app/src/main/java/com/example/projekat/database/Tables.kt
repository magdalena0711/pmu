package com.example.projekat.database

import android.graphics.Picture
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import org.json.JSONObject
import java.time.LocalTime
import java.util.Date

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = false) val username: String = "",
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "age") val age: Int = 0,
    @ColumnInfo(name = "dailyGoal") val dailyGoal: Double = 0.0,
    @ColumnInfo(name = "currentKm") val currentKm: Double = 0.0,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "picture") val picture: Picture,
    @ColumnInfo(name = "metaAddress") val metaAddress: String
)

@Entity(tableName = "post_table",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["username"],
            childColumns = ["username"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["username"])])
data class Post(
    @PrimaryKey(autoGenerate = true) val idP: Int = 0,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "allData") val allData: JSONObject
    //vreme kad je objava okacena - LocalTime
    //vreme trcanja - Int(h,m,s)
    //km - Double
    //putanja???
)

@Entity(tableName = "challenge_table")
data class Challenge(
    @PrimaryKey(autoGenerate = true) val idC: Int = 0,
    @ColumnInfo(name = "coordStart") val coordStart: String,
    @ColumnInfo(name = "coordEnd") val coordEnd: String,
    @ColumnInfo(name = "qrContentStart") val qrContentStart: String,
    @ColumnInfo(name = "qrContentEnd") val qrContentEnd: String,
    @ColumnInfo(name = "qrPicStart") val qrPicStart: Picture,
    @ColumnInfo(name = "qrPicEnd") val qrPicEnd: Picture,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "time") val time: LocalTime,
    @ColumnInfo(name = "date") val date: Date
)

@Entity(
    tableName = "exceeded_table",
    primaryKeys = ["username","idC"],
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["username"],
            childColumns = ["username"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Challenge::class,
            parentColumns = ["idC"],
            childColumns = ["idC"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["username"]), Index(value = ["idC"])]
)
data class Exceeded(

    val username: String,
    val idC: Int
)