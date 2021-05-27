package ez.mus.jamendomusic.repository

import ez.mus.jamendomusic.api.ApiHelper
import ez.mus.jamendomusic.model.Cocktails
import ez.mus.jamendomusic.model.JamAnswer

class Repository(private val apiHelper: ApiHelper) {
    suspend fun getSongs(
        clientId: String,
        format: String,
        limit: String,
        searchRequest: String
    ): JamAnswer {
        return apiHelper.getSongs(clientId, format, limit, searchRequest)
    }
    suspend fun getAge(name:String):Cocktails{
        return apiHelper.getCocktails(name)
    }
}