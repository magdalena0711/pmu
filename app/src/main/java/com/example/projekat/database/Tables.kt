package com.example.projekat.database

import android.graphics.Picture
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import org.json.JSONObject
import java.time.LocalTime

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val idU: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "age") val age: Int = 0,
    @ColumnInfo(name = "dailyGoal") val dailyGoal: Double = 0.0,
    @ColumnInfo(name = "currentKm") val currentKm: Double = 0.0,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "password") val password: String,
    //tip za sliku mozda treba da se promeni
    @ColumnInfo(name = "picture") val picture: Picture,
    //tip za meta adresu je najbolje da bude String, jer je konverzija najlaksa
    @ColumnInfo(name = "metaAddress") val metaAddress: String
)

@Entity(tableName = "post_table",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["idU"],
            childColumns = ["idUser"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["idUser"])])
data class Post(
    @PrimaryKey(autoGenerate = true) val idP: Int = 0,
    @ColumnInfo(name = "idUser") val idUser: Int,
    @ColumnInfo(name = "allData") val allData: JSONObject
)

@Entity(tableName = "challenge_table")
data class Challenge(
    @PrimaryKey(autoGenerate = true) val idC: Int = 0,
    @ColumnInfo(name = "picStart") val picStart: Picture,
    @ColumnInfo(name = "picEnd") val picEnd: Picture,
    @ColumnInfo(name = "coordStart") val coordStart: String,
    @ColumnInfo(name = "coordEnd") val coordEnd: String,
    @ColumnInfo(name = "qrContentStart") val qrContentStart: String,
    @ColumnInfo(name = "qrContentEnd") val qrContentEnd: String,
    @ColumnInfo(name = "qrPicStart") val qrPicStart: Picture,
    @ColumnInfo(name = "qrPicEnd") val qrPicEnd: Picture,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "time") val time: LocalTime
)

@Entity(
    tableName = "exceeded_table",
    primaryKeys = ["idU, idC"],
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["idU"],
            childColumns = ["idU"],
            onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Challenge::class,
            parentColumns = ["idC"],
            childColumns = ["idC"],
            onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["idU"]), Index(value = ["idC"])]
)
data class Exceeded(
    @ColumnInfo(name = "idU") val idU: Int,
    @ColumnInfo(name = "idC") val idC: Int
)