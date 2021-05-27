package ez.mus.jamendomusic.api


import ez.mus.jamendomusic.BuildConfig
import ez.mus.jamendomusic.model.Cocktails
import ez.mus.jamendomusic.model.JamAnswer
import ez.mus.jamendomusic.utils.baseUrl
import ez.mus.jamendomusic.utils.searchTrackUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//val jamId = "5aea3e42"


//val trackParam = "?client_id=$jamId&format=jsonpretty&limit=200&search="
val moreSongUrl = "&offset=200"

object MyRetrofitService {
    var loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
    private fun getClient(): OkHttpClient.Builder {
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
    }

    fun retrofit() =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getClient().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


}

public interface APIService {
    @GET("search.php")
    suspend fun getCocktails(@Query("s") name: String): Cocktails

    @GET(searchTrackUrl)
    suspend fun getTracks(
        @Query("client_id") clientId: String,
        @Query("format") format: String,
        @Query("limit") limit: String,
        @Query("search") searchRequest: String
    ): JamAnswer

}