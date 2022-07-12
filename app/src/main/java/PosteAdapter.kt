package com.example.poste

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.poste.de.syntaxinstitut.veritasapp.ui.community.CommunityFragmentDirections
import de.syntaxinstitut.veritasapp.databinding.ListPosteBinding

class PosteAdapter(private val posteListe: List<Poste>) :
    RecyclerView.Adapter<PosteAdapter.PosteViewHolder>() {
    class PosteViewHolder(val binding: ListPosteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosteViewHolder {
        val binding = ListPosteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PosteViewHolder, position: Int) {
        val poste = posteListe[position]
        holder.binding.posteTitel.text = poste.titel
        holder.binding.posteBild.setImageResource(poste.imageId)
        holder.itemView.setOnClickListener {
            val navController = holder.itemView.findNavController()
            navController.navigate(CommunityFragmentDirections.actionCommunityFragmentToDetailFragment(stringId = poste.titel.toInt(), imagId = poste.imageId, screenId = poste.bildScreen ))
        }
    }

    override fun getItemCount(): Int {
        return posteListe.size
    }
}
