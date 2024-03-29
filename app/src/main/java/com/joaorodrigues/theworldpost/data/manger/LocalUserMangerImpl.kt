package com.joaorodrigues.theworldpost.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.joaorodrigues.theworldpost.domain.manger.LocalUserManager
import com.joaorodrigues.theworldpost.util.Constants
import com.joaorodrigues.theworldpost.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
/**
This class is responsible for managing local data related to the user.
Uses DataStore, a Jetpack library, to store and retrieve application preferences asynchronously.
saveAppEntry() saves an application entry to the DataStore.
readAppEntry() retrieves application entry from the DataStore as a stream of booleans.
 */
class LocalUserMangerImpl(private val context: Context): LocalUserManager {

    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

    private object PreferencesKeys {
        val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
    }

}