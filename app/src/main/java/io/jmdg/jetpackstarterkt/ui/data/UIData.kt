package io.jmdg.jetpackstarterkt.ui.data

import io.jmdg.jetpackstarterkt.repository.entities.Request
import io.jmdg.jetpackstarterkt.repository.entities.RequestArray

/**
 * Created by Joshua de Guzman on 25/07/2018.
 */

data class UIData<T>(
        val request: Request<T>,
        val error: Throwable? = null
)

data class UIDataArray<T>(
        val request: RequestArray<T>,
        val error: Throwable? = null
)