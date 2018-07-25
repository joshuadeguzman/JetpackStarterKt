package io.jmdg.jetpackstarterkt.repository.db

import android.arch.persistence.room.*
import io.jmdg.jetpackstarterkt.repository.entities.User
import io.reactivex.Single

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

@Dao
interface UserDao {
    /**
     * Retrieves users from local database
     */
    @Query("SELECT * FROM users")
    fun getUsers(): Single<List<User>>

    /**
     * Insert (replaces when same instance is found) specific user in the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    /**
     * Delete specific user in the database
     */
    @Delete
    fun delete(user: User)

    /**
     * Delete all users in local database
     */
    @Query("DELETE FROM users")
    fun deleteAll()
}
