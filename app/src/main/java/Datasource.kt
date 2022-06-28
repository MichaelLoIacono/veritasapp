package com.example.poste

import de.syntaxinstitut.veritasapp.R

class Datasource {
    fun loadposte() :List<Poste> {
        return listOf(
            Poste("Yugi", R.drawable.bild1),
            Poste("Tobi", R.drawable.bild2 ),
            Poste("Kakashi", R.drawable.bild3 ),
            Poste("Deku", R.drawable.bild5 ),
            Poste("Green Ranger", R.drawable.bild6 ),


            )

    }
}