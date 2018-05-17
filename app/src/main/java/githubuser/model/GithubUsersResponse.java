package githubuser.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsersResponse {
    @SerializedName("Users")
    private ArrayList<GithubUsers> Users;

    public ArrayList<GithubUsers> getGithubUsers(){
        return Users;
    }
}
