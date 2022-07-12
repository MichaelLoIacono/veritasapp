package com.example.poste

import de.syntaxinstitut.veritasapp.R

class Datasource {
    fun loadposte() :List<Poste> {
        return listOf(
            Poste("Yugi", R.drawable.bild1),
            Poste("Tobi", R.drawable.bild2),
            Poste("Kakashi", R.drawable.bild3),
            Poste("Augilera", R.drawable.bild4),
            Poste("Deku", R.drawable.bild5),
            Poste("Son Goku", R.drawable.bild6),
            Poste("Green Ranger", R.drawable.bild7),
            Poste("Spider Man", R.drawable.bild8),
            Poste("Camoran", R.drawable.bild9),


            )

    }
}