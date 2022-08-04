package com.example.poste.de.syntaxinstitut.veritasapp.ui.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poste.ImageAdapter
import com.example.poste.de.syntaxinstitut.veritasapp.Adapter.PosteAdapter
import com.example.poste.de.syntaxinstitut.veritasapp.ui.two.ViewModel
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentCommunityBinding
import de.syntaxinstitut.veritasapp.ui.two.HomeFragmentDirections

class CommunityFragment : Fragment(R.layout.fragment_community) {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentCommunityBinding
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_community, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.posteListe
        viewModel.loadimages()
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        recyclerView.setHasFixedSize(true)

        viewModel.imageList.observe(viewLifecycleOwner) {
            recyclerView.adapter = ImageAdapter(it, "community")
        }
        binding.favoritBtn2.setOnClickListener {
            findNavController().navigate(CommunityFragmentDirections.actionCommunityFragmentToFavoritFragment())

            binding.profilButton.setOnClickListener {
                findNavController().navigate(CommunityFragmentDirections.actionCommunityFragmentToFragmentProfil())


            }


        }

    }
}