package com.example.poste

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