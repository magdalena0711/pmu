package com.example.projekat.database

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepo @Inject constructor(private val postDao: PostDao){
    val allPosts = postDao.getAllPosts()

    suspend fun insertPost(post: Post){
        postDao.insertPost(post)
    }

    suspend fun deletePost(post: Int){
        postDao.deletePost(post)
    }
}