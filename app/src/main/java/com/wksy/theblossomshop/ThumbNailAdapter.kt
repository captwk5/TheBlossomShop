package com.wksy.theblossomshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wksy.theblossomshop.databinding.ItemThumbnailBinding

class ThumbNailAdapter(private val context: Context) : RecyclerView.Adapter<ThumbNailAdapter.ViewHolder>() {
    private lateinit var viewBinding: ItemThumbnailBinding
    var datas = mutableListOf<ThumbNail>()

    interface ThumbNailClickListener{
        fun onClick(view:View, item: ThumbNail, position: Int)
    }

    private var listener: ThumbNailClickListener? = null

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(item: ThumbNail){
            viewBinding.descriptionTxt.text = item.description

            viewBinding.root.setOnClickListener {
                listener?.onClick(it, item, adapterPosition)
            }
        }
    }

    fun setListener(thumbNailClickListener: ThumbNailClickListener){
        this.listener = thumbNailClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        viewBinding = ItemThumbnailBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(viewBinding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int = datas.size
}