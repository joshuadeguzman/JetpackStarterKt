package io.jmdg.jetpackstarterkt.repository

import io.jmdg.jetpackstarterkt.repository.api.UserApi
import io.jmdg.jetpackstarterkt.repository.entities.Request
import io.jmdg.jetpackstarterkt.repository.entities.User
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

@Singleton
class UserRepository @Inject constructor(private val userApi: UserApi) {

    /**
     * Request to login user
     * @param username
     * @param password
     * @return Observable user data
     */
    fun loginUser(username: String,
                  password: String): Observable<Request<User>> {

        return userApi.loginUser(username, password)
                .doOnNext {
                    Timber.d(it.message)
                }

                .doOnError {
                    Timber.d(it)
                }
    }

    /**
     * Request to register user
     * @param username
     * @param password
     * @param email
     * @return Observable user data
     */
    fun registerUser(username: String,
                     password: String,
                     email: String): Observable<Request<User>> {
        return userApi.registerUser(username, password, email)
                .doOnNext {
                    Timber.d(it.message)
                }

                .doOnError {
                    Timber.d(it)
                }
    }

    /**
     * Request to get user details
     * @param userId
     * @param token
     * @return Observable user data
     */
    fun getUserDetails(userId: Int, token: String): Observable<Request<User>> {
        return userApi.getUserDetails(userId, token)
                .doOnNext {
                    Timber.d(it.message)
                }

                .doOnError {
                    Timber.d(it)
                }
    }

    /**
     * Request to change user's password
     * @param oldPassword
     * @param newPassword
     * @param token
     * @return Observable user data
     */
    fun changePassword(oldPassword: String, newPassword: String, token: String): Observable<Request<User>> {
        return userApi.changePassword(oldPassword, newPassword, token)
                .doOnNext {
                    Timber.d(it.message)
                }

                .doOnError {
                    Timber.d(it)
                }
    }

    /**
     * Request to update user's primary email
     * @param email
     * @param token
     * @return Observable user data
     */
    fun updatePrimaryEmail(email: String, token: String): Observable<Request<User>> {
        return userApi.updatePrimaryEmail(email, token)
                .doOnNext {
                    Timber.d(it.message)
                }

                .doOnError {
                    Timber.d(it)
                }
    }

    /**
     * Request to delete user's non-primary email from the email list
     * @param email
     * @param token
     * @return Observable user data
     */
    fun removeEmail(email: String, token: String): Observable<Request<User>> {
        return userApi.removeEmail(email, token)
                .doOnNext {
                    Timber.d(it.message)
                }

                .doOnError {
                    Timber.d(it)
                }
    }
}