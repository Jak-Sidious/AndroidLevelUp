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

/**
 * Class that deals with the default data/activity shown when the app loads.
 * @author jakanakiwanuka
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static List users = new ArrayList();

    static {
        users.add(new GithubUsers("James", "James", "James Org"));
        users.add(new GithubUsers("baln", "Freaky ", "Murder Inc"));
        users.add(new GithubUsers("Jason", "nyahaha", "Murder Inc"));
        users.add(new GithubUsers("Mr Tickles", "Mr tickles", "Isle Of Perpetual Tickling"));
        users.add(new GithubUsers("Bust a shot", "HARAM", "Haram"));
        users.add(new GithubUsers("Insanity", "joker", "Aren't we all"));
        users.add(new GithubUsers("ISSSS", "Was?", "wasn't it"));
        users.add(new GithubUsers("your", "my", "Ours"));
        users.add(new GithubUsers("friend", "Henemy", "yass"));
        users.add(new GithubUsers("Nyaahhhhclea", "I don know", "Neither do i"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.users_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GitHubAdaptor(users, this);
        mRecyclerView.setAdapter(mAdapter);
    }


}
