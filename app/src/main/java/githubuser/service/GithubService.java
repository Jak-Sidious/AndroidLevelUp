package githubuser.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {
    private Retrofit retrofit = null;

    public GitHubAPI getApi(){
        String BASE_URL = "http://api.github.com/";

        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GitHubAPI.class);
    }
}
