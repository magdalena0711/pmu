package com.example.projekat.database

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Picture
import androidx.room.TypeConverter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream


class PictureConverter {
    @TypeConverter
    fun fromPicture(picture: Picture?): ByteArray?{
        if(picture == null) return null

        val bitmap = Bitmap.createBitmap(
            picture.width, picture.height, Bitmap.Config.ARGB_8888
        )
        //Bitmap.Config.ARGB_8888 je konfiguracija koja definiše način na koji se pikseli skladište u memoriji za Bitmap
        //  Ova konfiguracija utiče na kvalitet slike i memorijsku potrošnju.

        val canvas = Canvas(bitmap)
        picture.draw(canvas)

        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }

    @TypeConverter
    fun toPicture(data: ByteArray?): Picture?{
        if(data == null) return null
        val bitmap = BitmapFactory.decodeStream(ByteArrayInputStream(data))

        val picture = Picture()
        val canvas = picture.beginRecording(bitmap.width, bitmap.height)
        canvas.drawBitmap(bitmap, 0f, 0f, null)
        picture.endRecording()
        return picture
    }
}