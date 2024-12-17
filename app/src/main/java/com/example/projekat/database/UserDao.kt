package com.example.projekat.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table ORDER BY idU ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAllUsersByName(): Flow<List<User>>

    @Query("SELECT * FROM user_table WHERE idU = :id")
    fun getCurrentUser(id: Int): User

    @Query("SELECT * FROM user_table WHERE metaAddress = :meta AND password = :pass")
    fun getUser(meta: String, pass: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()

    @Query("DELETE FROM user_table WHERE idU = :id")
    suspend fun deleteUser(id: Int)


}