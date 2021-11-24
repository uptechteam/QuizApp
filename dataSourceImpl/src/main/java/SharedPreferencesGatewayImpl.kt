import model.PreferencesRepository

class SharedPreferencesGatewayImpl(private val preferencesRepository: PreferencesRepository) :
    SharedPreferencesGateway {
    override fun saveToken(token: String) {
       preferencesRepository.saveToken(token)
    }

    override fun getToken(): String {
        return preferencesRepository.getToken()
    }
}