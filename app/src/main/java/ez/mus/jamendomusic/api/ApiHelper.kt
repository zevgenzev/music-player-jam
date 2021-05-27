package ez.mus.jamendomusic.api

class ApiHelper(private val apiService: APIService) {
    suspend fun getSongs(clientId: String, format: String, limit: String, searchRequest: String) =
        apiService.getTracks(clientId, format, limit, searchRequest)

    suspend fun getCocktails(name:String)=apiService.getCocktails(name)
}