package com.kstechsolutions.mvvm.modules.posts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kstechsolutions.mvvm.R;
import com.kstechsolutions.mvvm.modules.posts.data.IPostView;
import com.kstechsolutions.mvvm.modules.posts.model.PostAndPhoto;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */


public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostsViewHolder> {
    private PostAndPhoto mData;
    private Context mContext;
    private IPostView mListener;

    public PostListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public PostListAdapter.PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostListAdapter.PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(PostListAdapter.PostsViewHolder holder, int position) {
        holder.tvTitle.setText(mData.mPosts.get(position).getTitle());
        Glide.with(mContext).load(mData.mPhotos.get(position).getUrl()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mData != null ? mData.mPosts.size() : 0;
    }

    public void setListener(IPostView listener) {
        mListener = listener;
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.imageview)
        ImageView imageView;

        private PostsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cl_item)
        void onBodyClick() {
            mListener.onListItemClicked(mData.mPosts.get(getAdapterPosition()).getId(),
                    mData.mPosts.get(getAdapterPosition()).getTitle(),
                    mData.mPhotos.get(getAdapterPosition()).getUrl());
        }
    }


    public void setData(PostAndPhoto data) {
        mData = data;
        notifyDataSetChanged();
    }
}

