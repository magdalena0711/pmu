package com.example.projekat.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM post_table ORDER BY idP ASC")
    fun getAllPosts(): Flow<List<Post>>

    @Query("SELECT * FROM post_table WHERE idUser = :id")
    fun getAllPostsByThisUser(id: Int): Flow<List<Post>>

    //vrlo verovatno ce biti potrebno jos upita
}