package model

import android.content.Context
import android.content.SharedPreferences
import com.panhuk.core.BuildConfig

class PreferencesRepository(context: Context) {
    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(BuildConfig.APP_PREFERENCES, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPreferences
            .edit()
            .putString(BuildConfig.TOKEN, token)
            .apply()
    }

    fun getToken() = sharedPreferences.getString(BuildConfig.TOKEN, "")!!
}