package de.syntaxinstitut.veritasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import de.syntaxinstitut.veritasapp.databinding.ActivityMainBinding

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: ActivityMainBinding


    /**
     * Lifecycle Methode, wird aufgerufen wenn Activity erstellt wird
     *
     * @param savedInstanceState      Save state vom view
     */

        // navigation Komponenten
        private lateinit var drawerLayout: DrawerLayout
        private lateinit var navView: NavigationView
        private lateinit var navController: NavController

        // AppBarKonfiguration
        private val  idSets = setOf(R.id.fragment_profil,R.id.fragment_profildaten,R.id.fragment_sammlung)
        private lateinit var appBarConfig: AppBarConfiguration

    /**
     * wird aufgerufen wenn die app Createt.
     */
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

        /**
         * Toolbar Funktion
         */
            val toolbar: Toolbar = findViewById(R.id.toolbar)
            setSupportActionBar(toolbar)

            drawerLayout = findViewById(R.id.drawer_layout)
            navView= findViewById(R.id.nav_view)
            navController= findNavController(R.id.nav_host)
            appBarConfig = AppBarConfiguration(idSets,drawerLayout)
            setupActionBarWithNavController(navController,appBarConfig)
            navView.setupWithNavController(navController)

    }

    /**
     * Navigiert zur APPbar
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host)
        return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
    }

}





