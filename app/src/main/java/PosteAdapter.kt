package com.example.poste

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
    }

    override fun getItemCount(): Int {
        return posteListe.size
    }
}
