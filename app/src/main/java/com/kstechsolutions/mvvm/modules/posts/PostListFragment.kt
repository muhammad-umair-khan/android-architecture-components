package com.kstechsolutions.mvvm.modules.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kstechsolutions.mvvm.databinding.FragPostlistBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by muhammadumairshafique on 29/09/2019.
 */

class PostListFragment : DaggerFragment() {
    private lateinit var binding: FragPostlistBinding
    private val postViewModel: PostListViewModel by viewModels(factoryProducer = { factory })

    @Inject
    lateinit var mAdapter: PostListAdapter
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragPostlistBinding.inflate(inflater, container, false).apply {
            viewModel = postViewModel
            lifecycleOwner = viewLifecycleOwner
            listContainer.recyclerView.adapter = mAdapter

            mAdapter.setListener(listener = object : PostListAdapter.OnItemClickListener {
                override fun onItemClicked(item: PostAndPhoto) {
                    findNavController().navigate(PostListFragmentDirections.openComments(item.post.id, item.photo.url))
                }
            })
        }
        return binding.root
    }
}