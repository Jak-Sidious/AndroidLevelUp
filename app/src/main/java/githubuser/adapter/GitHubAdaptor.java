package githubuser.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jakanakiwanuka.mrmlevelup.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import githubuser.model.GithubUsers;
import githubuser.view.DetailActivity;

/**
 * An adaptor to cater to the generation of the RecyclerView.
 */
public class GitHubAdaptor extends RecyclerView.Adapter<GitHubAdaptor.UserViewHolder> {
    List<GithubUsers> users = new ArrayList();
    Context context;

    /**
     * Instance of Github Adaptor declared to enable passing of the data accordingly.
     * @param users List of created users
     * @param context data passed to the adaptor
     */
    public GitHubAdaptor(List<GithubUsers> users, Context context) {
        this.users = users;
        this.context = context;
    }

    /**
     * View Holder to contain the data of the individual when clicked.
     */
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView mUserImageView; //change this later
        TextView mUserTextView;
        TextView mUserTextView2;

        /**
         * Instance of view holder that is not bound to any data yet.
         * @param view the view containing all the user data.
         */
        public UserViewHolder(View view) {
            super(view);
            mUserImageView = view.findViewById(R.id.user_image);
            mUserTextView = view.findViewById(R.id.user_name);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent
                .getContext()).inflate(R.layout.content_main,
                parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final GithubUsers githubUser = users.get(position);
        holder.mUserTextView.setText(githubUser.getUserName());
        Picasso.with(context)
                .load(githubUser.getProfileImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mUserImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userDetail = new Intent(v.getContext(), DetailActivity.class);
                userDetail.putExtra("githubImage", githubUser.getProfileImage());
                userDetail.putExtra("githubUser", githubUser.getUserName());
                userDetail.putExtra("userOrg", githubUser.getOrganizationUrl());
                v.getContext().startActivity(userDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


}
