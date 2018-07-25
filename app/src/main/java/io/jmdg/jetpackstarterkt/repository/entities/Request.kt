package io.jmdg.jetpackstarterkt.repository.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Joshua de Guzman on 24/07/2018.
 */

data class Request<T>(
        @SerializedName("status_code")
        val statusCode: Int,
        @SerializedName("message")
        val message: String,
        @SerializedName("result")
        val result: T
)

data class RequestArray<T>(
        @SerializedName("status_code")
        val statusCode: Int,
        @SerializedName("message")
        val message: String,
        @SerializedName("results")
        val results: T,
        @SerializedName("paging")
        val paging: Paging
)

data class Paging(
        @SerializedName("count")
        val count: Int,
        @SerializedName("page_count")
        val pageCount: Int,
        @SerializedName("links")
        val links: Links
)

data class Links(
        @SerializedName("next")
        var next: Int,
        @SerializedName("previous")
        var previous: Int
)