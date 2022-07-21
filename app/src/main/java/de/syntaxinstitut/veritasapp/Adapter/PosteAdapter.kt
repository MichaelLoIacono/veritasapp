package com.example.poste.de.syntaxinstitut.veritasapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.poste.Poste
import com.example.poste.de.syntaxinstitut.veritasapp.ui.community.CommunityFragmentDirections
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.SammlungFragmentDirections
import de.syntaxinstitut.veritasapp.databinding.ListPosteBinding

class PosteAdapter(private val posteListe: List<Poste>, private val currentFragment: String) :
    RecyclerView.Adapter<PosteAdapter.PosteViewHolder>() {
    class PosteViewHolder(val binding: ListPosteBinding) : RecyclerView.ViewHolder(binding.root)

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosteViewHolder {
        val binding = ListPosteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PosteViewHolder, position: Int) {
        val poste = posteListe[position]
        holder.binding.posteTitel.text = poste.titel.toString()
        holder.binding.posteBild.setImageResource(poste.imageId)
        holder.itemView.setOnClickListener {
            val navController = holder.itemView.findNavController()
            navController.navigate(SammlungFragmentDirections.actionFragmentSammlungToDetailFragment(position))
        }
    }


    override fun getItemCount(): Int {
        return posteListe.size
    }
}
