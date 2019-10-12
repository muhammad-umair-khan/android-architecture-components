package com.kstechsolutions.mvvm.modules.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kstechsolutions.mvvm.data.databinding.BindableAdapter
import com.kstechsolutions.mvvm.databinding.LayPostItemBinding
import javax.inject.Inject

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

class PostListAdapter @Inject constructor() : ListAdapter<PostAndPhoto, PostListAdapter.ViewHolder>(DIFF_CALLBACK), BindableAdapter<List<PostAndPhoto>> {
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayPostItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    override fun setData(data: List<PostAndPhoto>) {
        submitList(data)
    }

    fun setListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    inner class ViewHolder(private val binding: LayPostItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostAndPhoto, listener: OnItemClickListener) {
            binding.item = item
            binding.clItem.setOnClickListener { listener.onItemClicked(item) }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(item: PostAndPhoto)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PostAndPhoto>() {
            override fun areItemsTheSame(oldItem: PostAndPhoto, newItem: PostAndPhoto) = oldItem.post == newItem.post

            override fun areContentsTheSame(oldItem: PostAndPhoto, newItem: PostAndPhoto) = oldItem == newItem
        }
    }
}