package com.kin.data.util

import android.annotation.SuppressLint
import com.kin.domain.exception.TokenExpirationException
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun String.toDate(): Date {
    return SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").parse(this) ?: throw TokenExpirationException()
}

@SuppressLint("SimpleDateFormat")
fun Long.toForestTimeDate(): Date {
    return SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(this).toDate()
}