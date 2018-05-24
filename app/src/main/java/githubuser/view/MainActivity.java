package githubuser.view;

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
public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private static List<GithubUsers> users = new ArrayList();
    private final GithubUsersPresenter presenter = new GithubUsersPresenter(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.users_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        presenter.getGithubUsers(mRecyclerView);

        mAdapter = new GitHubAdaptor(users, this);
        mRecyclerView.setAdapter(mAdapter);
    }

}
