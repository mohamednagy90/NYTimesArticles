package com.nytimesarticles.data

import android.accounts.NetworkErrorException
import retrofit2.Response
import java.net.HttpURLConnection

/**
 * the base class for all HTTP calls in the app
 * for the API calls themselves, they're in the models.* packages declared as remote data sources.
 */
class Resource<out T> constructor(val status: Status, val data: T?, var exception: Exception?) {

    enum class Status {
        SUCCESS, ERROR, LOADING, SUCCESS_DB_INSERTION
    }

    companion object {
        // creates a SUCCESS resource for HTTP 200, and ERROR otherwise
        fun <T> create(response: Response<T>?): Resource<T> {
            return if (response?.code() == HttpURLConnection.HTTP_OK) {
                success(response.body())

            } else {
                error(NetworkErrorException(Exception("Response Code: ${response?.code()}")))
            }
        }

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(exception: Exception?): Resource<T> {
            return Resource(Status.ERROR, null, exception)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.ERROR, data, null)
        }
    }
}