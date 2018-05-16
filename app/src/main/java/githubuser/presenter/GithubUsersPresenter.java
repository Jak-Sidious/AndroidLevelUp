package githubuser.presenter;

import android.content.Context;

import java.util.ArrayList;

import githubuser.model.GithubUsers;
import githubuser.model.GithubUsersResponse;
import githubuser.service.GithubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubUsersPresenter {
    private GithubService GitService;
    private Context context;

    public GithubUsersPresenter(Context context){
        this.context = context;

        if (GitService == null) {
            this.GitService = new GithubService();
        }

    }

    public void getGithubUsers(){
        GitService
                .getApi()
                .getGithubUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse data = response.body();
                        if (data != null && data.getGithubUsers() != null){
                            ArrayList<GithubUsers> githubUsersList = data.getGithubUsers();
                        }

                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

}
