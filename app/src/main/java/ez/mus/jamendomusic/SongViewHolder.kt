package ez.mus.jamendomusic

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ez.mus.jamendomusic.utils.OnRvItemClickListener

class SongViewHolder(itemView: View, private val listener: OnRvItemClickListener) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var imageSong: ImageView? = null
    var nameSong: TextView? = null
    var nameArtist: TextView? = null
    var duration: TextView? = null

    init {
        itemView.setOnClickListener(this)
        imageSong = itemView.findViewById(R.id.ivThumb)
        nameSong = itemView.findViewById(R.id.tvSongName)
        nameArtist = itemView.findViewById(R.id.tvArtistName)
        duration = itemView.findViewById(R.id.tvDuration)
    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        if (adapterPosition != -1)
            listener.onItemClick(position)
    }
}