package de.syntaxinstitut.veritasapp.ui.two

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.poste.de.syntaxinstitut.veritasapp.Adapter.PosteAdapter
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false )
        return binding.root
    }

    lateinit var adapter: PosteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val constraintLayout: ConstraintLayout = view.findViewById(R.id.mainLayout)

        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

   binding.button2.setOnClickListener{
       findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCommunityFragment())

   }

        binding.button.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFragmentShowroom())

        }

        binding.button3.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFragmentProfil())

        }





    }

}