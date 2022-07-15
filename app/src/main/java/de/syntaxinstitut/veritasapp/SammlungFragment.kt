
package de.syntaxinstitut.veritasapp
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poste.Datasource
import com.example.poste.PosteAdapter
import de.syntaxinstitut.veritasapp.databinding.FragmentSammlungBinding

/* -------------------- Klassen Variablen -------------------- */

class SammlungFragment : Fragment(R.layout.fragment_sammlung) {

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentSammlungBinding


/* -------------------- Lifecycle -------------------- */
    /**
     * Lifecycle Methode wenn das View erstellt wird
     *
     * @param inflater                Layout Inflater
     * @param container               View Gruppe
     * @param savedInstanceState      Eventuelle saveStates
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sammlung, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val posteList = Datasource(requireContext()).loadPostes()
        val recyclerView = binding.posteListe2
        recyclerView.layoutManager = GridLayoutManager(activity,3)
        recyclerView.adapter = PosteAdapter(posteList)
        recyclerView.setHasFixedSize(true)


    }
}

