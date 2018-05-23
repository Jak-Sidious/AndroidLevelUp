package githubuser.presenter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import githubuser.model.GithubUsers;
import githubuser.model.GithubUsersResponse;
import githubuser.service.GithubService;
import githubuser.adapter.GitHubAdaptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * A Presneter acts upon model data and cormats data for the view.
 * @author Jakana Kiwanuka
 */
@SuppressWarnings("PMD")
public class GithubUsersPresenter {
    private GithubService gitService;
    private final Context context; //change later

    /**
     * Public declaration of the presenter.
     * @param context the data to be passed to the presenter
     */
    public GithubUsersPresenter(Context context) {
        this.context = context;

        if (gitService == null) {
            this.gitService = new GithubService();
        }

    }

    /**
     * Method to get github Users.
     * @param recyclerView the recycler view for get github users
     */
    public void getGithubUsers(final RecyclerView recyclerView) {
        gitService
                .getApi()
                .getGithubUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call,
                                           Response<GithubUsersResponse> response) {
                        GithubUsersResponse data = response.body();
                        if (data != null && data.getGithubUsers() != null) {
                           List<GithubUsers> githubUsersList = data.getGithubUsers();
                           RecyclerView.Adapter adapter = new GitHubAdaptor(githubUsersList,
                                   context);
                           recyclerView.setAdapter(adapter);
                           recyclerView.smoothScrollToPosition(0);

                        }

                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong");
                        } catch (InterruptedException e) {
                            Log.d("ERROR_RETRIEVING_USERS", e.getLocalizedMessage());
                        }
                    }
                });

    }

}
