package com.example.poste.de.syntaxinstitut.veritasapp.Datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Diese Klasse repräsentiert einen Bildtitel von der API
 */

@Entity
data class ImageData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val userID: String,
    val bildname: String,
    val file: String,
    var like: Boolean = false,
    var favorit: Boolean = false,
)