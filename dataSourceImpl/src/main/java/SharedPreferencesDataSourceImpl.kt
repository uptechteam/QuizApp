import model.PreferencesRepository

class SharedPreferencesDataSourceImpl(private val preferencesRepository: PreferencesRepository) :
    SharedPreferencesDataSource {
    override suspend fun saveToken(token: String) {
       preferencesRepository.saveToken(token)
    }

    override suspend fun getToken(): String? {
        return preferencesRepository.getToken()
    }
}