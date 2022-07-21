package com.example.poste.de.syntaxinstitut.veritasapp.ui.two

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import com.example.poste.Datasource
import com.example.poste.de.syntaxinstitut.veritasapp.remote.VeritasApi
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

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
}



