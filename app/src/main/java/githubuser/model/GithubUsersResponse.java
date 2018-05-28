package githubuser.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A Response refers to return value form a server request.
 * @author Jakana Kiwanuka
 */
public class GithubUsersResponse {
    @SerializedName("items")
    public List<GithubUsers> users;

    /**
     * Public array list to return a user list.
     * @return users
     */
    public List<GithubUsers> getGithubUsers() {
        return users;
    }
}
