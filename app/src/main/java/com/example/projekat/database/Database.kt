package com.example.projekat.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@TypeConverters(DateConverter::class, LocalTimeConverter::class, PictureConverter::class, JSONObjectConverter::class)
@Database(entities = [User::class, Post::class, Challenge::class, Exceeded::class], version = 1, exportSchema = false)
abstract class Database:RoomDatabase (){
    abstract fun userDao(): UserDao
    abstract fun postDao(): PostDao
    abstract fun challengeDao(): ChallengeDao
    abstract fun exceededDao(): ExceededDao

    companion object {
        private var INSTANCE: com.example.projekat.database.Database? = null

        fun getDatabase(context: Context, scope: CoroutineScope): com.example.projekat.database.Database {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.projekat.database.Database::class.java,
                    "word_database"
                ).addCallback(DatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                return@synchronized instance
            }
        }
    }
    private class DatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch { populateDatabase(database.userDao(), database.challengeDao()) }
            }
        }

        suspend fun populateDatabase(userDao: UserDao, challengeDao: ChallengeDao) {
            userDao.deleteAll()
            /*val admin = User(name = "Ilija", lastname = "Miletic", age = 22)
            userDao.insertUser(User(word = "Hello"))
            userDao.insert(Word(word = "World!"))*/
            //OVO SE MORA IZMENITIIII!!!!
        }
    }
}