package githubuser.view;


import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import com.example.jakanakiwanuka.mrmlevelup.R;
import java.util.ArrayList;
import java.util.List;

import githubuser.adapter.GitHubAdaptor;
import githubuser.model.GithubUsers;
import githubuser.presenter.GithubUsersPresenter;

/**
 * Class that deals with the default data/activity shown when the app loads.
 * @author jakanakiwanuka
 */
public class MainActivity extends AppCompatActivity
        implements GithubUsersPresenter.ViewGitHubUsers {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    List<GithubUsers> users = new ArrayList();
    private final GithubUsersPresenter presenter =
            new GithubUsersPresenter(MainActivity.this);
    static final  String ALL_KEYS = "list_state";
    Parcelable liststate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayGitHubUsers(users);

        if (savedInstanceState != null) {
            presenter.getGithubUsers(mRecyclerView);
            onRestoreInstanceState(savedInstanceState);
        } else {
            presenter.getGithubUsers(mRecyclerView);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        liststate = mLayoutManager.onSaveInstanceState();
        savedInstanceState.putParcelable(ALL_KEYS, liststate);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            liststate = savedInstanceState.getParcelable(ALL_KEYS);
            displayRecycleView(users);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * Method to display the RecycleView.
     * @param user ArrayList that is parameter
     */
    public void displayRecycleView(List<GithubUsers> user) {
        RecyclerView.Adapter adapter = new GitHubAdaptor(users, this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void displayGitHubUsers(List<GithubUsers> use) {
        users = use;
        mRecyclerView = findViewById(R.id.users_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter adapter = new GitHubAdaptor(users, this);
        mRecyclerView.setAdapter(adapter);
    }
}
