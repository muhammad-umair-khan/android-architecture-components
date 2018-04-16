package com.kstechsolutions.mvvm.modules.comments.view;

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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kstechsolutions.mvvm.R;
import com.kstechsolutions.mvvm.modules.base.BaseFragment;
import com.kstechsolutions.mvvm.modules.comments.adapter.CommentsAdapter;
import com.kstechsolutions.mvvm.modules.comments.data.ICommentView;
import com.kstechsolutions.mvvm.modules.comments.model.Comment;
import com.kstechsolutions.mvvm.modules.comments.viewmodel.CommentViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */

public class CommentListFragment extends BaseFragment implements ICommentView {
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    @Inject
    CommentsAdapter mAdapter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.iv_post_image)
    ImageView ivPostImage;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private CommentViewModel mCommentsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comments, container, false);
        setUnBinder(ButterKnife.bind(this, rootView));
        mCommentsViewModel = ViewModelProviders.of(this, mViewModelFactory).get(CommentViewModel.class);
        getActivityComponent().inject(this);
        mCommentsViewModel.setView(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        subscribeToLiveData();
    }

    private void initUI() {
        String postTitle = getArguments().getString(getString(R.string.arg_post_title));
        mToolbar.setTitle(postTitle);
        String postImageUrl = getArguments().getString(getString(R.string.arg_post_image_url));
        Glide.with(this).load(postImageUrl).into(ivPostImage);
        recyclerView.setAdapter(mAdapter);
    }

    private void subscribeToLiveData() {
        mCommentsViewModel.getCommentsLiveData(getArguments().getInt(getString(R.string.arg_post_id))).observe(this, this::onCommentsFetched);
    }


    @Override
    public void onCommentsFetched(ArrayList<Comment> data) {
        mAdapter.setData(data);
    }
}
