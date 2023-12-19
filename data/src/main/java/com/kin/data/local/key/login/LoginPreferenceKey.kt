package com.kin.data.local.key.login

import androidx.datastore.preferences.core.stringPreferencesKey

object LoginPreferenceKey {

    val ACCESS_TOKEN = stringPreferencesKey("access_token")

    val ACCESS_TIME = stringPreferencesKey("access_time")

    val REFRESH_TOKEN = stringPreferencesKey("refresh_token")

    val REFRESH_TIME = stringPreferencesKey("refresh_time")
}