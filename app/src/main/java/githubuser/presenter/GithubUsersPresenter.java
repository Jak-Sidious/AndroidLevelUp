package githubuser.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import githubuser.model.GithubUsers;
import githubuser.model.GithubUsersResponse;
import githubuser.service.GithubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * A Presneter acts upon model data and cormats data for the view.
 * @author Jakana Kiwanuka
 */
public class GithubUsersPresenter {
    private GithubService gitService;
    private Context context;

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
     */
    public void getGithubUsers() {
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
