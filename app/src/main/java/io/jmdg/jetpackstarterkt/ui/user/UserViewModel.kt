package io.jmdg.jetpackstarterkt.ui.user

import android.arch.lifecycle.ViewModel
import io.jmdg.jetpackstarterkt.repository.UserRepository
import io.jmdg.jetpackstarterkt.repository.entities.User
import io.jmdg.jetpackstarterkt.ui.data.UIData
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    fun loginUser(username: String, password: String): Observable<UIData<User>> {
        return userRepository.loginUser(username, password)
                .map {
                    UIData(it)
                }

                .doOnError {
                    Timber.d(it)
                }
    }

    fun registerUser(username: String, password: String, email: String): Observable<UIData<User>> {
        return userRepository.registerUser(username, password, email)
                .map {
                    UIData(it)
                }
    }

    fun changePassword(oldPassword: String, newPassword: String, token: String): Observable<UIData<User>> {
        return userRepository.changePassword(oldPassword, newPassword, token)
                .map {
                    UIData(it)
                }
    }

    fun updatePrimaryEmail(email: String, token: String): Observable<UIData<User>> {
        return userRepository.updatePrimaryEmail(email, token)
                .map {
                    UIData(it)
                }
    }

    fun removeEmail(email: String, token: String): Observable<UIData<User>> {
        return userRepository.removeEmail(email, token)
                .map {
                    UIData(it)
                }
    }

    fun getUserDetail(userId: Int, token: String): Observable<UIData<User>> {
        return userRepository.getUserDetails(userId, token)
                .map {
                    UIData(it)
                }
    }

}