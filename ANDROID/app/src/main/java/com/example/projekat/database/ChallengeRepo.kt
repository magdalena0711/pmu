package com.example.projekat.database

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ChallengeRepo @Inject constructor(private val challengeDao: ChallengeDao){
    val allChallanges = challengeDao.getAllChallenges()

    suspend fun insertChallenge(challenge: Challenge){
        challengeDao.insertChallenge(challenge)
    }

}