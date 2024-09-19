package com.zyasin.notestakingapp.data.datastore


import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("user_preferences")

// Can be used to store and retrieve a user's key in the app's persistent storage

class PreferencesDataStore(private val context: Context) {

    companion object {
        val USER_KEY = stringPreferencesKey("user_key")
    }

    val userKeyFlow: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_KEY]
        }

    suspend fun saveUserKey(userKey: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_KEY] = userKey
        }
    }
}
