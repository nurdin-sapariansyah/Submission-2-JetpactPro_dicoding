package com.nurdin.submission1jetpackpro.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nurdin.submission1jetpackpro.R
import com.nurdin.submission1jetpackpro.data.response.MovieShow
import kotlinx.android.synthetic.main.item_content.view.*

class MvAdapter: RecyclerView.Adapter<MvAdapter.ViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    private var listData = ArrayList<MovieShow>()
    fun setData(data: List<MovieShow>?) {
        if (data == null) return
        this.listData.clear()
        this.listData.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgUrl = "https://image.tmdb.org/t/p/w300/"

        fun bind(show: MovieShow) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(imgUrl + show.image)
                    .error(R.drawable.video_player)
                    .into(imageView)
                tv_title.text = show.title

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(show) }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieShow)
    }
}