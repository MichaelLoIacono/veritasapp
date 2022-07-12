package com.example.poste.de.syntaxinstitut.veritasapp.ui.two

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentDetailBinding



class DetailFragment : Fragment() {

    private lateinit var  binding: FragmentDetailBinding
    private var stringId = 0
    private var imagId = 0
    private var screenId = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stringId = it.getInt("stringId")
            imagId = it.getInt("imagId")
            screenId = it.getInt("screenId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bildTitel = getString(stringId)


        binding.bildTitel.text = bildTitel

        binding.bildScreen.setImageResource(screenId)

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}