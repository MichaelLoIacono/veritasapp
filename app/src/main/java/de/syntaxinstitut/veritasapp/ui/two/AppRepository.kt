package com.example.poste.de.syntaxinstitut.veritasapp.ui.two

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData
import com.example.poste.de.syntaxinstitut.veritasapp.local.VeritasDatabase
import com.example.poste.de.syntaxinstitut.veritasapp.remote.VeritasApi
import com.example.poste.de.syntaxinstitut.veritasapp.remote.VeritasApiService
import kotlinx.coroutines.delay

class AppRepository(private val api: VeritasApi) {


    private val _imageList = MutableLiveData<List<ImageData>>()
    val imageList: LiveData<List<ImageData>>
        get() = _imageList

// die Bilder werden in der Image List gespeichert
    suspend fun getImages() {
        try {
            _imageList.value = api.retrofitService.getImages()
        } catch (
            exception: Exception
        ) {
            Log.d("AppRepository", "AppDontWork: $exception")
        }


    }
}