package ez.mus.jamendomusic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ez.mus.jamendomusic.api.ApiHelper
import ez.mus.jamendomusic.repository.Repository
import java.lang.IllegalArgumentException

class MyViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnlineSongViewModel::class.java)) {
            return OnlineSongViewModel(Repository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}