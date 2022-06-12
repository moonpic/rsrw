package com.fmaldonado.akiyama.ui.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.fmaldonado.akiyama.data.models.content.Anime
import com.fmaldonado.akiyama.data.models.content.Episode
import com.fmaldonado.akiyama.data.models.content.MainScreenContent
import com.fmaldonado.akiyama.databinding.LatestAnimeItemBinding

class LatestAnimeAdapter(
    private val animes: List<MainScreenContent>,
) : RecyclerView.Adapter<LatestAnimeAdapter.LatestAnimeViewHolder>() {


    inner class LatestAnimeViewHolder(
        val binding: LatestAnimeItemBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestAnimeViewHolder {
        val binding = LatestAnimeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return LatestAnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestAnimeViewHolder, position: Int) {
        val anime = animes[position]
        holder.binding.title.text = anime.title
        holder.binding.title.isSelected = true
        holder.binding.image.load(anime.image) {
            crossfade(true)
            crossfade(300)
            transformations(RoundedCornersTransformation(10f))
        }
    }

    override fun getItemCount(): Int = animes.size


}