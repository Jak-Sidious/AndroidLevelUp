//package adaptor;
package githubuser.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jakanakiwanuka.mrmlevelup.R;

import java.util.List;

import githubuser.model.GithubUsers;

public class GitHubAdaptor extends RecyclerView.Adapter<GitHubAdaptor.UserViewHolder> {
    List<GithubUsers> Users;
    Context context;

    public GitHubAdaptor(List<GithubUsers> Users, Context context){
        this.Users=Users;
        this.context=context;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView mUserImageView;
         TextView mUserTextView;

        public UserViewHolder(View view){
            super(view);
            mUserImageView = view.findViewById(R.id.user_image);
            mUserTextView = view.findViewById(R.id.user_name);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final GithubUsers githubUser = Users.get(position);
        holder.mUserTextView.setText(githubUser.getUserName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userDetail = new Intent(v.getContext(), DetailActivity.class);
                userDetail.putExtra("githubUser", githubUser.getUserName());
                userDetail.putExtra("userOrg", githubUser.getOrganizationUrl());
                v.getContext().startActivity(userDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }


}