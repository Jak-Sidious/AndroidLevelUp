package githubuser.service;


import githubuser.model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * An interface to make the github call and create a response accordingly.
 */
public interface GitHubAPI {
    /**
     * Interface implementation.
     * @return getGithubUsers the method to get all github users
     */
    @GET("/search/users?q=location:nairobi+language:java&per_page=10&sort=followers")
    Call<GithubUsersResponse> getGithubUsers();
}
