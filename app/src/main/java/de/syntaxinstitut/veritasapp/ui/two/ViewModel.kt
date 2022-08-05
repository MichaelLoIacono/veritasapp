package com.example.poste.de.syntaxinstitut.veritasapp.ui.two

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.example.poste.Datasource
import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData
import com.example.poste.de.syntaxinstitut.veritasapp.local.getDatabase
import com.example.poste.de.syntaxinstitut.veritasapp.remote.VeritasApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel(application: Application) : AndroidViewModel(application) {

    val database = getDatabase(application)
    val posteList = Datasource(application).loadPostes()
    private var _dataBaseImageListe = MutableLiveData<List<ImageData>>()
    val dataBaseImageList: LiveData<List<ImageData>>
        get() = _dataBaseImageListe
    val mediator = MediatorLiveData<List<ImageData>>()


    // Enzieht die Informationen aus der AppRepository
    private val repository = AppRepository(
        VeritasApi
    )

    // Hier wird die BildListe aud der Api Call gespeichert ( wird in LiveData gespeichert)
    val imageList = repository.imageList

    // Jedes mal wenn die Api Call neu ausgeführt werden soll, wird die Funktion aufgerufen.
    fun loadimages() {
        viewModelScope.launch {
            repository.getImages()
        }
    }

    fun getImagesDatabase() {
        viewModelScope.launch {
            _dataBaseImageListe = database.veritasDatabaseDao.getAll().toMutableLiveData()

        }
    }

    fun saveImage(image: ImageData) {
        viewModelScope.launch {
            database.veritasDatabaseDao.insertIMAGE(image)
        }
    }

    fun deletImage(image: ImageData) {
        viewModelScope.launch {
            database.veritasDatabaseDao.deleteById(image.bildname)
        }
    }
}

// wandelt LiveData in MutableLiveData
fun <T> LiveData<T>.toMutableLiveData(): MutableLiveData<T> {
    val mediatorLiveData = MediatorLiveData<T>()
    mediatorLiveData.addSource(this) {
        mediatorLiveData.value = it
    }
    return mediatorLiveData
}

