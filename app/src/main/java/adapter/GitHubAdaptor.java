//package adaptor;
package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jakanakiwanuka.mrmlevelup.GitHubUsers;
import com.example.jakanakiwanuka.mrmlevelup.R;

import java.util.List;

public class GitHubAdaptor extends RecyclerView.Adapter<GitHubAdaptor.UserViewHolder> {
    List<GitHubUsers> Users;
    Context context;

    public GitHubAdaptor(List<GitHubUsers> Users, Context context){
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
        final GitHubUsers githubUser = Users.get(position);
        holder.mUserTextView.setText(githubUser.Username);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userDetail = new Intent(v.getContext(), DetailActivity.class);
                userDetail.putExtra("githubUser", githubUser.Username);
                v.getContext().startActivity(userDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }


}