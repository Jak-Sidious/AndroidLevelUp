package githubuser.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {

    @SerializedName("userName")
    private String userName;

    @SerializedName("userOrg")
    private String userOrg;

    public GithubUsers(String userName, String userOrg){
        this.userName=userName;
        this.userOrg=userOrg;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserOrg() {
        return userOrg;
    }
}
