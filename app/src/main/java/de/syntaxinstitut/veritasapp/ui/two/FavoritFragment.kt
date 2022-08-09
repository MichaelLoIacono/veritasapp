package de.syntaxinstitut.veritasapp.ui.two

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.poste.ImageAdapter
import com.example.poste.de.syntaxinstitut.veritasapp.Adapter.FavoriteAdapter
import com.example.poste.de.syntaxinstitut.veritasapp.ui.community.CommunityFragmentDirections
import com.example.poste.de.syntaxinstitut.veritasapp.ui.two.ViewModel
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentCommunityBinding
import de.syntaxinstitut.veritasapp.databinding.FragmentFavoritBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FavoritFragment : Fragment() {
    private lateinit var binding: FragmentFavoritBinding
    private val viewModel: ViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorit, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


       // val bildTitel = poste.bildname


      //  binding.bildTitel.text = bildTitel

       // val imgUri = poste.file.toUri().buildUpon().scheme("http").build()

        //binding.bildScreen.load(imgUri) {
            //error(R.drawable.ic_baseline_broken_image_24)
            //transformations(RoundedCornersTransformation(10f))
        //}

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


