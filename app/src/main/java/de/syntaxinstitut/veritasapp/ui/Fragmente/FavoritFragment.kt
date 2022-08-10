package de.syntaxinstitut.veritasapp.ui.Fragmente

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poste.de.syntaxinstitut.veritasapp.Adapter.FavoriteAdapter
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentFavoritBinding
import de.syntaxinstitut.veritasapp.ui.ViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FavoritFragment : Fragment() {
    private lateinit var binding: FragmentFavoritBinding
    private val viewModel: ViewModel by activityViewModels()



    /**
     * /**
     * Created die View.
    */
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorit, container, false)

        return binding.root
    }

    /**
     * /**
     * wird aufgerufen wenn er fertig created.
    */
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {




        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.posteListe
        viewModel.getImagesDatabase()
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        recyclerView.setHasFixedSize(true)

        viewModel.dataBaseImageList.observe(viewLifecycleOwner) {
            recyclerView.adapter = FavoriteAdapter(it, "favorite")
        }

    }



}


