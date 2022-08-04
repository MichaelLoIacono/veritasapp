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
    fun saveImage(image:ImageData){
        viewModelScope.launch {
            database.veritasDatabaseDao.insertIMAGE(image)
        }
    }
    fun deletImage(image:ImageData){
        viewModelScope.launch {
            //database.veritasDatabaseDao.deleteById(image.id)
            println("hallo"+image.id)
        }
    }
}



