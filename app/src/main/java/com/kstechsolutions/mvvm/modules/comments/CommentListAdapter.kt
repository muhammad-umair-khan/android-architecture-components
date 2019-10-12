package com.kstechsolutions.mvvm.modules.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kstechsolutions.mvvm.data.databinding.BindableAdapter
import com.kstechsolutions.mvvm.databinding.LayCommentItemBinding
import com.kstechsolutions.mvvm.modules.posts.PostAndPhoto
import com.kstechsolutions.mvvm.modules.posts.PostListAdapter
import javax.inject.Inject

/**
 * Created by muhammad umair shafique on 29/09/2019.
 */

class CommentListAdapter @Inject constructor() : ListAdapter<Comment, CommentListAdapter.ViewHolder>(DIFF_CALLBACK), BindableAdapter<List<Comment>> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayCommentItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun setData(data: List<Comment>) {
        submitList(data)
    }

    inner class ViewHolder(private val binding: LayCommentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: Comment) {
            binding.comment = comment
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Comment>() {
            override fun areItemsTheSame(oldItem: Comment, newItem: Comment) = oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Comment, newItem: Comment) = oldItem == newItem
        }
    }
}