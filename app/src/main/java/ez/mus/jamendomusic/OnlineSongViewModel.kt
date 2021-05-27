package ez.mus.jamendomusic

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ez.mus.jamendomusic.api.*
import ez.mus.jamendomusic.model.Cocktails
import ez.mus.jamendomusic.model.CocktailsRecipes
import ez.mus.jamendomusic.model.Song
import ez.mus.jamendomusic.repository.Repository
import ez.mus.jamendomusic.utils.Resource
import ez.mus.jamendomusic.utils.format
import ez.mus.jamendomusic.utils.limit
import kotlinx.coroutines.launch

class OnlineSongViewModel(repository: Repository) : ViewModel() {
    private val _onlineSongLiveData: MutableLiveData<Resource<ArrayList<Song>>> = MutableLiveData()
    val onlineSongLiveData: LiveData<Resource<ArrayList<Song>>> get() = _onlineSongLiveData
    private val jamId = BuildConfig.JAM_API_KEY
    var listSong = arrayListOf<Song>()
    private val repository = repository
    fun requestSong(searchRequest: String) {
        Log.e("ViewModel", "requestSong: ")
        Log.e("VM", "thread = ${Thread.currentThread().name}")
        viewModelScope.launch {
            _onlineSongLiveData.value = Resource.loading(null)

            try {
                var result =
                    repository.getSongs(jamId, format, limit, searchRequest)//getAge(searchRequest)
                Log.e("VM", "onResponse results: ${result.headers}")
//            Log.e("VM", "onResponse results: ${result.drinks[0].strCategory}")
                Log.e("VM", "in coroutine thread = ${Thread.currentThread().name}")

                listSong =
                    result.results as ArrayList<Song>
            } catch (e: Exception) {
                _onlineSongLiveData.value = Resource.error(e.message!!, null)
                e.printStackTrace()
            }
            _onlineSongLiveData.value = Resource.success(listSong)

        }
    }

    override fun onCleared() {
        super.onCleared()

    }

    fun itemClick(position: Int) {
        Log.e("VM", "itemClick position: $position")
    }
}