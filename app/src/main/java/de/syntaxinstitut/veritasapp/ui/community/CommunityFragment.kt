package com.example.poste.de.syntaxinstitut.veritasapp.ui.community

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poste.Datasource
import com.example.poste.PosteAdapter
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentCommunityBinding
import de.syntaxinstitut.veritasapp.databinding.FragmentTwoBinding
import de.syntaxinstitut.veritasapp.ui.two.TwoViewModel

class CommunityFragment : Fragment(R.layout.fragment_community) {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentCommunityBinding


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
        val posteList = Datasource().loadposte()
        val recyclerView = binding.posteListe
        recyclerView.layoutManager = GridLayoutManager(activity,3)
        recyclerView.adapter = PosteAdapter(posteList)
        recyclerView.setHasFixedSize(true)


    }


}
