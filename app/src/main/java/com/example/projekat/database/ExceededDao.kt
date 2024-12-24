package com.example.projekat.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExceededDao {
    @Query("SELECT * FROM exceeded_table WHERE username = :id")
    fun getMyExceededChallanges(id: String): Flow<List<Exceeded>>

    @Query("SELECT * FROM EXCEEDED_TABLE WHERE idC = :id")
    fun getAllUsersThatExceededThisChallenge(id: Int): Flow<List<Exceeded>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exceeded: Exceeded)
}