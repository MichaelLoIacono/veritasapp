package com.example.poste.de.syntaxinstitut.veritasapp.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData
import de.syntaxinstitut.veritasapp.R
import de.syntaxinstitut.veritasapp.databinding.ListPosteBinding

class FavoriteAdapter(private val posteListe: List<ImageData>, private val currentFragment: String) :
    RecyclerView.Adapter<FavoriteAdapter.PosteViewHolder>() {
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
        holder.binding.posteTitel.text = poste.userID.toString()
        val imgUri = poste.file.toUri().buildUpon().scheme("http").build()

        // Image Error
        holder.binding.posteBild.load(imgUri) {
            error(R.drawable.ic_baseline_broken_image_24)
            transformations(RoundedCornersTransformation(10f))
        }

    }

    /**
     * /**
     * zeigt an wie groß der inhalt der Liste ist.
    */
     */
    override fun getItemCount(): Int {
        return posteListe.size
    }
}