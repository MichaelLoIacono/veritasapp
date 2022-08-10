
package de.syntaxinstitut.veritasapp.ui.Fragmente
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poste.de.syntaxinstitut.veritasapp.Adapter.PosteAdapter
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentSammlungBinding
import de.syntaxinstitut.veritasapp.ui.ViewModel

/* -------------------- Klassen Variablen -------------------- */

class SammlungFragment : Fragment(R.layout.fragment_sammlung) {

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentSammlungBinding
    private val viewModel: ViewModel by activityViewModels()


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

    /**
     * wird aufgerufen wenn es fertig ist mit der Created.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val posteList = viewModel.posteList
        val recyclerView = binding.posteListe2
        recyclerView.layoutManager = GridLayoutManager(activity,3)
        recyclerView.adapter = PosteAdapter(posteList,"sammlung")
        recyclerView.setHasFixedSize(true)


    }
}

