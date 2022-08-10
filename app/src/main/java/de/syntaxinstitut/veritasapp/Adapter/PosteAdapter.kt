package com.example.poste.de.syntaxinstitut.veritasapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.poste.de.syntaxinstitut.veritasapp.Data.Datamodel.Poste
import de.syntaxinstitut.veritasapp.databinding.ListPosteBinding
import de.syntaxinstitut.veritasapp.ui.Fragmente.SammlungFragmentDirections


/**
 * /**
 * Der Adapter kümmert sich um meine ListItem.
*/
 */
class PosteAdapter(private val posteListe: List<Poste>, private val currentFragment: String) :
    RecyclerView.Adapter<PosteAdapter.PosteViewHolder>() {
    class PosteViewHolder(val binding: ListPosteBinding) : RecyclerView.ViewHolder(binding.root)

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosteViewHolder {
        val binding = ListPosteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PosteViewHolder(binding)
    }

    /**
     * /**
     * WIrd für jeden ListItem einmal ausgeführt und definiert den inhalt.
    */
     */
    override fun onBindViewHolder(holder: PosteViewHolder, position: Int) {
        val poste = posteListe[position]
        holder.binding.posteTitel.text = poste.titel.toString()
        holder.binding.posteBild.setImageResource(poste.imageId)
        holder.itemView.setOnClickListener {
            val navController = holder.itemView.findNavController()
            navController.navigate(SammlungFragmentDirections.actionFragmentSammlungToDetailFragment(position))
        }
    }

    /**
     * Liefert die größer der Liste
     */
    override fun getItemCount(): Int {
        return posteListe.size
    }
}
