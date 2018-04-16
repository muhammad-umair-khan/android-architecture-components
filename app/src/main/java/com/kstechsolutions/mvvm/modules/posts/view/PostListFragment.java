package com.kstechsolutions.mvvm.modules.posts.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kstechsolutions.mvvm.R;
import com.kstechsolutions.mvvm.modules.base.BaseFragment;
import com.kstechsolutions.mvvm.modules.comments.view.CommentListFragment;
import com.kstechsolutions.mvvm.modules.posts.adapter.PostListAdapter;
import com.kstechsolutions.mvvm.modules.posts.data.IPostView;
import com.kstechsolutions.mvvm.modules.posts.model.PostAndPhoto;
import com.kstechsolutions.mvvm.modules.posts.viewmodel.PostListViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class PostListFragment extends BaseFragment implements IPostView {
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    @Inject
    PostListAdapter mAdapter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private PostListViewModel mPostListViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_post_list, container, false);
        setUnBinder(ButterKnife.bind(this, rootView));
        mToolbar.setTitle(R.string.title_post);
        mPostListViewModel = ViewModelProviders.of(this, mViewModelFactory).get(PostListViewModel.class);
        getActivityComponent().inject(this);
        mPostListViewModel.setView(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        subscribeToLiveData();
    }

    private void initUI() {
        recyclerView.setAdapter(mAdapter);
        mAdapter.setListener(this);
    }

    private void subscribeToLiveData() {
        mPostListViewModel.getPostsLiveData().observe(this, this::onPostsPhotosFetched);
    }

    @Override
    public void onPostsPhotosFetched(PostAndPhoto data) {
        if (data != null)
            mAdapter.setData(data);
    }

    @Override
    public void onListItemClicked(int id, String title, String url) {
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.arg_post_id), id);
        bundle.putString(getString(R.string.arg_post_title), title);
        bundle.putString(getString(R.string.arg_post_image_url), url);
        CommentListFragment mFragment = new CommentListFragment();
        mFragment.setArguments(bundle);
        getChildFragmentManager().beginTransaction().add(R.id.child_container, mFragment).addToBackStack(mFragment.getTag()).commit();
    }


}
