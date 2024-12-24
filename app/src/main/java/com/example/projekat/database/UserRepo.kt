package com.example.projekat.database

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepo @Inject constructor(private val userDao: UserDao){
    val allUsers = userDao.getAllUsers()

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: String){
        userDao.deleteUser(user)
    }
}