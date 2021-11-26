interface SharedPreferencesDataSource {
    suspend fun saveToken(token: String)
    suspend fun getToken(): String?
}