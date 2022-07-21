package com.example.poste.de.syntaxinstitut.veritasapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData

/**
 *  RoomDatabase zum speichern der Memes
 */
@Database(entities = [ImageData::class], version = 1)
abstract class VeritasDatabase : RoomDatabase() {
    // Verknüpft die Database mit dem DAO Interface
    abstract val veritasDatabaseDao: VeritasDatabaseDao
}

// Hier wird eine Instanz der Database gespeichert
private lateinit var INSTANCE: VeritasDatabase

/**
 * Diese Funktion erstellt eine neue Database und liefert sie zurück,
 * falls noch keine Instanz der Database existiert
 */
fun getDatabase(context: Context): VeritasDatabase {
    synchronized(VeritasDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                VeritasDatabase::class.java,
                "veritas_deluxe_database"
            )
                .build()
        }
    }
    return INSTANCE
}