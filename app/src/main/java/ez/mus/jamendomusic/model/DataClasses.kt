package ez.mus.jamendomusic.model

import com.google.gson.annotations.SerializedName

//"id":"1828927",
//"name":"Enjoy Life - Happy Pop",
//"duration":165,
//"artist_id":"502043",
//"artist_name":"pinegroove",
//"artist_idstr":"pinegroove",
//"album_name":"Enjoy Life - Happy Pop",
//"album_id":"199122",
//"license_ccurl":"http:\/\/creativecommons.org\/licenses\/by-nc-nd\/3.0\/",
//"position":1,
//"releasedate":"2021-01-31",
//"album_image":"https:\/\/images.jamendo.com\/albums\/s199\/199122\/covers\/1.200.jpg",
//"audio":"https:\/\/mp3l.jamendo.com\/?trackid=1828927&format=mp31&from=rDeWDBEaWxNAPA9pF7K%2BcQ%3D%3D%7C5lzayynVy%2BqyRJVRIk4o2w%3D%3D",
//"audiodownload":"https:\/\/mp3d.jamendo.com\/download\/track\/1828927\/mp32\/",

data class Song(
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("artist_name") var artistName: String,
    @SerializedName("audiodownload") var url: String,
    @SerializedName("duration") var duration: String,
    @SerializedName("album_image") var image: String
)

//"headers":{
//    "status":"success",
//    "code":0,
//    "error_message":"",
//    "warnings":"",
//    "results_count":200,
//    "next":"https:\/\/api.jamendo.com\/v3.0\/tracks?client_id=5aea3e42&format=jsonpretty&limit=200&search=pop&offset=200"
//}
data class Header(
    var status: String,
    var code: Int,
    var error_message: String,
    var warnings: String,
    var results_count: Int,
    var next: String
)

data class JamAnswer(var headers: Header, var results: List<Song>)
data class Cocktails(var drinks: List<CocktailsRecipes>)

data class CocktailsRecipes(
    @SerializedName("dateModified")var idDrink: String,
    var strDrink: String,
    var strTags: String,
    var strCategory: String
)
