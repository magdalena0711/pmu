package com.example.projekat.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExceededDao {
    @Query("SELECT * FROM exceeded_table WHERE idU = :id")
    fun getMyExceededChallanges(id: Int): Flow<List<Exceeded>>

    @Query("SELECT * FROM EXCEEDED_TABLE WHERE idC = :id")
    fun getAllUsersThatExceededThisChallenge(id: Int): Flow<List<Exceeded>>
}