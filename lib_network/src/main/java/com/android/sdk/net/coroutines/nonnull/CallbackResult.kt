package com.android.sdk.net.coroutines.nonnull

import com.android.sdk.net.core.result.ExceptionFactory
import com.android.sdk.net.core.result.Result
import com.android.sdk.net.coroutines.*
import kotlinx.coroutines.delay
import timber.log.Timber

suspend fun <T : Any> apiCall(
    exceptionFactory: ExceptionFactory? = null,
    call: suspend () -> Result<T>
): CallResult<T> {

    val retryPostAction = retryPostAction()

    var result = realCall(call, true, exceptionFactory)

    if (result is CallResult.Error && retryPostAction.retry(result.error)) {
        result = realCall(call, true, exceptionFactory)
    }

    return result
}

suspend fun <T : Any> apiCallRetry(
    times: Int = RETRY_TIMES,
    delay: Long = RETRY_DELAY,
    exceptionFactory: ExceptionFactory? = null,
    checker: ((Throwable) -> Boolean)? = null,
    call: suspend () -> Result<T>,
): CallResult<T> {

    var result = apiCall(exceptionFactory, call)
    var count = 0

    repeat(times) {

        if (result is CallResult.Error && (checker == null || checker((result as CallResult.Error).error))) {
            delay(delay)
            Timber.d("executeApiCallRetry at ${++count}")
            result = apiCall(exceptionFactory, call)
        } else {
            return result
        }

    }

    return result
}
