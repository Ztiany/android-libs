@file:JvmName("IOUtils")

package com.android.base.utils.common

import com.blankj.utilcode.util.CloseUtils
import okio.BufferedSource
import okio.buffer
import okio.source
import java.io.IOException
import java.io.InputStream

fun InputStream.readUtf8(autoClose: Boolean = true): String {
    var source: BufferedSource? = null
    try {
        source = source().buffer()
        return source.readUtf8()
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        if (autoClose) {
            CloseUtils.closeIO(source)
        }
    }
    return ""
}