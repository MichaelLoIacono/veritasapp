package com.example.poste.de.syntaxinstitut.veritasapp.local

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData

/**
 * Das DAO (DatabaseAccessObject) stellt Funktionen für Database Operationen bereit
 */
@Dao
interface VeritasDatabaseDao {

    /**
     * Insert ist eine von Room vorgefertigte Anfrage zum Einfügen (eines Bild)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(imageData: List<ImageData>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIMAGE(imageData:ImageData)

    /**
     * Update ist eine von Room vorgefertigte Anfrage zum Aktualisieren (eines Bild)
     */
    @Update
    suspend fun update(imageData: ImageData)

    /**
     * Diese Funktion wählt alle Elemente in der Datenbank aus
     * Der Abruf wird in Query spezifiziert
     */
    @Query("SELECT * from ImageData")
    fun getAll(): LiveData<List<ImageData>>

    /**
     * Diese Funktion löscht alle Elemente aus der Datenbank
     * Der Abruf wird in Query spezifiziert
     */
    @Query("DELETE from ImageData")
    suspend fun deleteAll()

    /**
     * Diese Funktion löscht das Element mit der übergebenen ID aus der Datenbank
     * Der Abruf wird in Query spezifiziert
     */
    @Query("DELETE from ImageData WHERE bildname = :bildname")
    suspend fun deleteById(bildname: String)
}