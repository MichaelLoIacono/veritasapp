package com.example.poste

import android.content.Context
import de.syntaxinstitut.veritasapp.R



/**
 * Diese Klasse bereitet Daten aus den Ressourcen auf
 */
class Datasource(private val context: Context) {

    private val numberOfTitles = 9 // anpassen, wenn Anzahl an Bildtiteln geändert wurde

    /**
     * Diese Funktion holt die Titel & Bilder aus der Quelldatei
     * und liefert eine Liste aus Filmen zurück
     */
    fun loadPostes(): List<Poste> {
        // Die Liste an Bilder
        val postes = mutableListOf<Poste>()

        // Befülle die Liste
        for (index in 1..numberOfTitles) {

            // Hole den Titel und das Bild
           val title = getTitle(index)
            val image = getImage(title)
            val screen = getScreen(title)


            // Füge ein Poste Objekt hinzu
            postes.add(

                Poste(title, image,screen)


            )
        }
        return postes
    }



    /**
     * Diese Funktion liefert den Titel Nummer index aus der Quelle
     */
    private fun getTitle(index: Int): Int {
        return context.resources.getIdentifier(
            "posteTitle$index",
            "string",
            context.packageName
        )
    }
    /**
     * Diese Funktion liefert zu jedem übergebenen Titel das entsprechende Bild
     */
    private fun getImage(titleRes: Int): Int {

        // Hole den Titel aus den Ressourcen
        val title = context.getString(titleRes).lowercase()
            .replace(" ", "_")
            .replace("ü", "_")
            .replace("ö", "_")

        // Liefere das entsprechende Bild aus der Quelle
        return context.resources.getIdentifier(
            title,
            "drawable",
            context.packageName
        )
    }

    private fun getScreen(titleRes: Int): Int {

        // Hole den Titel aus den Ressourcen
        val title = context.getString(titleRes).lowercase()
            .replace(" ", "_")
            .replace("ü", "_")
            .replace("ö", "_")

        // Liefere das entsprechende Bild aus der Quelle
        return context.resources.getIdentifier(
            title+"_screen",
            "drawable",
            context.packageName
        )
    }
}