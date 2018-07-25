package io.jmdg.jetpackstarterkt.repository.api

import io.jmdg.jetpackstarterkt.repository.entities.Request
import io.jmdg.jetpackstarterkt.repository.entities.User
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

interface UserApi {

    /**
     * Login user to the database
     * @FormUrlEncoded Denotes that the request body will use form URL encoding
     * @Field Named pair for a form-encoded request
     * @param username
     * @param password
     * @return Observable user data request
     */
    @FormUrlEncoded
    @POST("/api/v1/user/login/")
    fun loginUser(@Field("username") username: String,
                  @Field("password") password: String): Observable<Request<User>>

    /**
     * Registers user to the database
     * @FormUrlEncoded Denotes that the request body will use form URL encoding
     * @Field Named pair for a form-encoded request
     * @param username
     * @param password
     * @param email
     * @return Observable user data request
     */
    @FormUrlEncoded
    @POST("/api/v1/user/register/")
    fun registerUser(@Field("username") username: String,
                     @Field("password") password: String,
                     @Field("primary_email") email: String): Observable<Request<User>>

    /**
     * Retrieves user info
     * @Path places userId on a specific {path} on the @GET annotation url
     * @Header Replaces the header with the value of its target
     * @param token: generated random set of alphanumeric string provided by the backend once the user logged in (eg. JWT Tokens, TokenAuthorization)
     * @return Observable user data request
     */
    @GET("/api/v1/user/{user_id}")
    fun getUserDetails(@Path("user_id") userId: Int,
                       @Header("Authorization") token: String): Observable<Request<User>>


    /**
     * Updates user's password
     * @FormUrlEncoded Denotes that the request body will use form URL encoding
     * @Field Named pair for a form-encoded request
     * @param oldPassword
     * @param newPassword
     * @param token: generated random set of alphanumeric string provided by the backend once the user logged in (eg. JWT Tokens, TokenAuthorization)
     * @return Observable user data request
     */
    @FormUrlEncoded
    @PATCH("/api/v1/user/password/change/")
    fun changePassword(@Field("old_password") oldPassword: String,
                       @Field("new_password") newPassword: String,
                       @Header("Authorization") token: String): Observable<Request<User>>

    /**
     * Updates user's password
     * @FormUrlEncoded Denotes that the request body will use form URL encoding
     * @Field Named pair for a form-encoded request
     * @param email
     * @param token: generated random set of alphanumeric string provided by the backend once the user logged in (eg. JWT Tokens, TokenAuthorization)
     * @return Observable user data request
     */
    @FormUrlEncoded
    @PATCH("/api/v1/user/emails/primary/")
    fun updatePrimaryEmail(@Field("email") email: String,
                           @Header("Authorization") token: String): Observable<Request<User>>

    /**
     * Remove a particular email from user (except the set primary email)
     * @FormUrlEncoded Denotes that the request body will use form URL encoding
     * @Field Named pair for a form-encoded request
     * @param email
     * @param token: generated random set of alphanumeric string provided by the backend once the user logged in (eg. JWT Tokens, TokenAuthorization)
     * @return Observable user data request
     */
    @FormUrlEncoded
    @DELETE("/api/v1/user/emails/")
    fun removeEmail(@Field("email") email: String,
                    @Header("Authorization") token: String): Observable<Request<User>>

}

interface PostApi