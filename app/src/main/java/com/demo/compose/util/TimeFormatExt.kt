package com.demo.compose.util

import java.text.SimpleDateFormat
import java.util.*

fun Long.simpleFormat(): String = formatTime("mm:ss")

fun Long.formatTime(pattern: String): String =
    SimpleDateFormat(pattern, Locale.CHINA).format(this)