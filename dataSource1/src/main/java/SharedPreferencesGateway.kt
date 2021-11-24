interface SharedPreferencesGateway {
    fun saveToken(token: String)
    fun getToken(): String
}