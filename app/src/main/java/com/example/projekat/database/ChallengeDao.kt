package com.example.projekat.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ChallengeDao {
    @Query("SELECT * FROM challenge_table ORDER BY idC ASC")
    fun getAllChallenges(): Flow<List<Challenge>>


}