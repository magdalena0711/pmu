package com.example.projekat.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM post_table ORDER BY idP ASC")
    fun getAllPosts(): Flow<List<Post>>

    @Query("SELECT * FROM post_table WHERE username = :id")
    fun getAllPostsByThisUser(id: String): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPost(post: Post)

    @Query("DELETE FROM post_table WHERE idP = :id")
    suspend fun deletePost(id: Int)

    //vrlo verovatno ce biti potrebno jos upita
}