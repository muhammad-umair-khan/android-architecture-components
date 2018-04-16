package com.kstechsolutions.mvvm.modules.comments.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kstechsolutions.mvvm.R;
import com.kstechsolutions.mvvm.modules.comments.model.Comment;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muhammadumairshafique on 16/04/2018.
 */


public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
    private ArrayList<Comment> mList;

    @Inject
    public CommentsAdapter() {

    }

    @Override
    public CommentsAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentsAdapter.CommentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.CommentViewHolder holder, int position) {
        holder.tvName.setText(mList.get(position).getName());
        holder.tvEmail.setText(mList.get(position).getEmail());
        holder.tvBody.setText(mList.get(position).getBody());
    }


    @Override
    public int getItemCount() {
        return (mList != null && mList.size() > 0) ? 3 : 0;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_email)
        TextView tvEmail;
        @BindView(R.id.tv_body)
        TextView tvBody;

        private CommentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setData(ArrayList<Comment> list) {
        mList = list;
        notifyDataSetChanged();
    }
}

