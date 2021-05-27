package ez.mus.jamendomusic

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ez.mus.jamendomusic.model.Cocktails
import ez.mus.jamendomusic.model.CocktailsRecipes
import ez.mus.jamendomusic.model.Song
import ez.mus.jamendomusic.utils.OnRvItemClickListener

class OnlineSongAdapter(private val listener: OnRvItemClickListener) :
    RecyclerView.Adapter<SongViewHolder>() {
    var songsList: List<Song> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.song_item, parent, false)
        return SongViewHolder(itemView, listener)
    }


    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.nameArtist?.text = songsList[position].artistName
        holder.nameSong?.text = songsList[position].name
        holder.duration?.text = songsList[position].duration
        try {
            Picasso.get().load(songsList[position].image).into(holder.imageSong)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return songsList.size
    }

    fun setData(data: List<Song>) {
        Log.e("ADAPTER", "setData: ")
        songsList = data
        notifyDataSetChanged()

    }


}