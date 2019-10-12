package com.kstechsolutions.mvvm.modules.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kstechsolutions.mvvm.data.databinding.setImageUrl
import com.kstechsolutions.mvvm.databinding.FragCommentlistBinding
import com.kstechsolutions.mvvm.databinding.FragPostlistBinding
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by muhammad umair shafique on 29/09/2019.
 */

class CommentListFragment : DaggerFragment() {
    private var imageUrl = ""
    private lateinit var binding: FragCommentlistBinding
    private val commentListViewModel: CommentListViewModel by viewModels(factoryProducer = { factory })

    @Inject
    lateinit var mAdapter: CommentListAdapter
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            val args = CommentListFragmentArgs.fromBundle(requireArguments())
            commentListViewModel.setPostId(args.postId)
            imageUrl = args.imageUrl
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragCommentlistBinding.inflate(inflater, container, false).apply {
            viewModel = commentListViewModel
            lifecycleOwner = viewLifecycleOwner
            recyclerView.adapter = mAdapter

            Picasso.get().load(imageUrl).into(imageView)
        }
        return binding.root
    }
}