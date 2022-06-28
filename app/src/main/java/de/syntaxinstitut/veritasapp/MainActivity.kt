package de.syntaxinstitut.veritasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.poste.Datasource
import de.syntaxinstitut.veritasapp.databinding.ActivityMainBinding

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: ActivityMainBinding

    /* -------------------- Lifecycle -------------------- */
    val posteListe = Datasource().loadposte()
    val recyclerView = binding.posteListe
    recyclerView.adapter = PosteAdapter(posteListe)
    recyclerView.setHasFixedSize(true)

    /**
     * Lifecycle Methode, wird aufgerufen wenn Activity erstellt wird
     *
     * @param savedInstanceState      Save state vom view
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Das Binding zur XML-Datei
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}





