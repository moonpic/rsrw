package com.fmaldonado.akiyama.data.repositories.anime

import androidx.lifecycle.MutableLiveData
import com.fmaldonado.akiyama.data.models.content.Anime
import com.fmaldonado.akiyama.data.models.content.Episode
import com.fmaldonado.akiyama.data.network.AruppiDataSource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AnimeRepository
@Inject
constructor(
    private val aruppiDataSource: AruppiDataSource
) {

    val latestAnimes = MutableLiveData<List<Anime>>()
    val latestEpisodes = MutableLiveData<List<Episode>>()
    val latestOvas = MutableLiveData<List<Anime>>()
    val latestMovies = MutableLiveData<List<Anime>>()
    val latestSpecials = MutableLiveData<List<Anime>>()

    suspend fun getLatestAnimes() {
        val animes = aruppiDataSource.getAnimes()
        latestAnimes.postValue(animes)
    }

    suspend fun getLatestEpisodes() {
        val episodes = aruppiDataSource.getEpisodes()
        latestEpisodes.postValue(episodes)
    }

    suspend fun getLatestOvas() {
        val ovas = aruppiDataSource.getOvas()
        latestOvas.postValue(ovas)
    }

    suspend fun getLatestMovies() {
        val movies = aruppiDataSource.getMovies()
        latestMovies.postValue(movies)
    }

    suspend fun getLatestSpecials() {
        val specials = aruppiDataSource.getSpecials()
        latestSpecials.postValue(specials)
    }

    suspend fun getAnimeInfo(animeId: String,animeTitle:String): Anime {

        return aruppiDataSource.getAnimeInfo(animeId.split("/").last(),animeTitle)
    }
}

