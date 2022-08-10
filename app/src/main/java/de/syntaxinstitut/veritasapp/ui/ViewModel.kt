package de.syntaxinstitut.veritasapp.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.poste.de.syntaxinstitut.veritasapp.Data.Datasource
import com.example.poste.de.syntaxinstitut.veritasapp.Data.AppRepository
import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData
import com.example.poste.de.syntaxinstitut.veritasapp.local.getDatabase
import com.example.poste.de.syntaxinstitut.veritasapp.remote.VeritasApi
import kotlinx.coroutines.launch

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

    //Wenn noch keine images geladen sind, ist imageList.value null und somit ImageList.value?.isEmpty() ungleich false.
    // Der Ausdruck ist auch nicht true aber der code in der if Bedingung(das Laden der Bilder) wird nur ausgeführt wenn noch keine Bilder geladen sind.
    // ToDo muss noch richtig umgeschrieben werden, dient nur zum Fixen des Problem.

    // Jedes mal wenn die Api Call neu ausgeführt werden soll, wird die Funktion aufgerufen.
    fun loadimages() {
        if (imageList.value?.isEmpty() !=false) {
           viewModelScope.launch {
               repository.getImages()
           }
       }
    }

    /**
     * nimmt die Image aus der Database
     */
    fun getImagesDatabase() {
        viewModelScope.launch {
            _dataBaseImageListe = database.veritasDatabaseDao.getAll().toMutableLiveData()

        }
    }

    /**
     * Speichert die Image
     */
    fun saveImage(image: ImageData) {
        viewModelScope.launch {
            database.veritasDatabaseDao.insertIMAGE(image)
        }
    }

    /**
     * Löscht Image
     */
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

