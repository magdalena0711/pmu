package com.example.projekat.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY username ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAllUsersByName(): Flow<List<User>>

    @Query("SELECT * FROM user_table WHERE username = :id")
    fun getCurrentUser(id: String): User

    @Query("SELECT * FROM user_table WHERE metaAddress = :metaAddress AND password = :pass")
    fun getUser(metaAddress: String, pass: String): User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()

    @Query("DELETE FROM user_table WHERE username = :id")
    suspend fun deleteUser(id: String)


}