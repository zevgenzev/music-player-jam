package ez.mus.jamendomusic.utils

const val baseUrl = "https://api.jamendo.com/v3.0/"
const val baseUrl2 = "https://www.thecocktaildb.com/api/json/v1/1/"
const val searchTrackUrl = "tracks/"
const val format = "jsonpretty"
const val limit = "200"

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

interface OnRvItemClickListener {
    fun onItemClick(position: Int)
}