package com.example.poste.de.syntaxinstitut.veritasapp.Data.Datamodel

/**
 * Diese Klasse repräsentiert einen Bildtitel
 */
data class Poste(
    val titel:Int,
    val imageId:Int,
    val screenId:Int,
    var like:Boolean= false,
) {
}