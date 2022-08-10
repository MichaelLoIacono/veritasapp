package com.example.poste.de.syntaxinstitut.veritasapp.ui.two

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.poste.de.syntaxinstitut.veritasapp.Data.Datamodel.Poste
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentDetailBinding
import de.syntaxinstitut.veritasapp.ui.ViewModel


class DetailFragment : Fragment() {
    private val viewModel: ViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding
    private lateinit var poste: Poste

    /**
     * wird aufgerufen wenn die app Createt.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            poste  = viewModel.posteList[it.getInt("position")]
        }
    }

    /**
     * /**
     * Created die View.
    */
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )
        return binding.root
    }

    /**
     * /**
     * wird aufgerufen wenn er fertig created.
    */
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bildTitel = getString(poste.titel)


        binding.favoritBtn.isVisible = false

        binding.bildTitel.text = bildTitel

        binding.bildScreen.setImageResource(poste.screenId)

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        if (poste.like == true) {

            binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_242)
        } else {
            binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)

        }
        binding.likeButton.setOnClickListener {
            poste.like = !poste.like
            if (poste.like == true) {

                binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_242)
            } else {
                binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)

            }
        }
    }

}
