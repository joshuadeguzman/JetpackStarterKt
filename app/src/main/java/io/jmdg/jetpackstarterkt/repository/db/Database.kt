package io.jmdg.jetpackstarterkt.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.jmdg.jetpackstarterkt.repository.entities.User

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

@Database(entities = [(User::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}