package githubuser.service;


import githubuser.model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubAPI {
    @GET("search/users?q=location:nairobi+language:java")
    Call<GithubUsersResponse> getGithubUsers();
}
