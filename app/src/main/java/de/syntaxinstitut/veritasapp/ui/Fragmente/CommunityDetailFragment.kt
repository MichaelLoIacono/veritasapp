package com.example.poste.de.syntaxinstitut.veritasapp.ui.two

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentDetailBinding
import de.syntaxinstitut.veritasapp.ui.ViewModel


class CommunityDetailFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels()
    private lateinit var  binding: FragmentDetailBinding
    private lateinit var poste: ImageData

    /**
     * wird aufgerufen wenn die app Createt.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            poste  = viewModel.imageList.value!![it.getInt("position")]
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

        val bildTitel = poste.bildname


        binding.bildTitel.text = bildTitel

        val imgUri = poste.file.toUri().buildUpon().scheme("http").build()

        /**
         * Error Image, wenn das Bild nicht korrekt geladen wird
         */

        binding.bildScreen.load(imgUri) {
            error(R.drawable.ic_baseline_broken_image_24)
            transformations(RoundedCornersTransformation(10f))
        }

        /**
         * Hier werden die Like und Favorit Button ausgeführt
         */
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        if(poste.like == true){

            binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_242)
        } else {
            binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)

        }
        binding.likeButton.setOnClickListener{
            poste.like = !poste.like
            if(poste.like == true){

                binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_242)
            } else {
                binding.likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_off_alt_24)

            }
        }

        if(poste.favorit == true){

            binding.favoritBtn.setImageResource(R.drawable.ic_baseline_bookmark_24)
        } else {
            binding.favoritBtn.setImageResource(R.drawable.ic_outline_bookmark_border_24)

        }
        binding.favoritBtn.setOnClickListener{
            poste.favorit = !poste.favorit
            if(poste.favorit == true){
            viewModel.saveImage(poste)
                binding.favoritBtn.setImageResource(R.drawable.ic_baseline_bookmark_24)
            } else {
                binding.favoritBtn.setImageResource(R.drawable.ic_outline_bookmark_border_24)
                viewModel.deletImage(poste)


            }
        }

    }
}