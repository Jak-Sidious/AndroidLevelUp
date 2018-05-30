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
        implements GithubUsersPresenter.View {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    List<GithubUsers> users = new ArrayList();
    private final GithubUsersPresenter presenter =
            new GithubUsersPresenter(this);
    static final  String ALL_KEYS = "list_state";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList(ALL_KEYS);
            displayGitHubUsers(users);
        } else {
            presenter.getGithubUsers();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(ALL_KEYS,
                (ArrayList<? extends Parcelable>) users);
    }

    @Override
    public void displayGitHubUsers(List<GithubUsers> usersList) {
        users = usersList;
        mRecyclerView = findViewById(R.id.users_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter adapter = new GitHubAdaptor(users, this);
        mRecyclerView.setAdapter(adapter);
    }

}
