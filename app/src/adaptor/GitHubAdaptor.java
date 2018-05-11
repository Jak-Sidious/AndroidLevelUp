//package adaptor;
package com.example.jakanakiwanuka.mrmlevelup;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GitHubAdaptor extends RecyclerView.Adapter<GitHubAdaptor.UserViewHolder> {

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView mUserImageView;
        private TextView mUserTextView;

        public UserViewHolder(View view){
            super(view);
            mUserImageView = view.findViewById(R.id.user_image);
            mUserTextView = view.findViewById(R.is.user_name);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInFlater.from(parent.getContext().inflate(R.layout.content_main, parent, false);
        return new UserViewHolder(userDetailsRowView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {}

    @Override
    public int getItemCount() {
        // since we don't have a list of data to display yet
        return 1;
        }
}