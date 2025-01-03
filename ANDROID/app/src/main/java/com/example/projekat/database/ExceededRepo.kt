package com.example.projekat.database

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExceededRepo @Inject constructor(private val exceededDao: ExceededDao){
    suspend fun insert(exceeded: Exceeded){
        exceededDao.insert(exceeded)
    }
}