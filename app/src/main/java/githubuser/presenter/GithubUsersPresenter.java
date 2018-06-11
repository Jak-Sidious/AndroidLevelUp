package githubuser.presenter;



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
    public View view;
    private GithubService gitService;

    /**
     * Public declaration of the presenter.
     * @param view represents the main activity
     */
    public GithubUsersPresenter(View view) {
        this.view = view;

        if (gitService == null) {
            this.gitService = new GithubService();
        }

    }

    /**
     * Interface method to deal with the change of orientation.
     */
    public interface View {
        /**
         * Method to display the github Users.
         * @param userList Array list containing users.
         */
        void displayGitHubUsers(List<GithubUsers> userList);
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

                        GithubUsersResponse userResponse = response.body();
                        List<GithubUsers> gitHubUsersList;

                        assert userResponse != null;

                        gitHubUsersList = userResponse.getGithubUsers();
                        view.displayGitHubUsers(gitHubUsersList);
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
