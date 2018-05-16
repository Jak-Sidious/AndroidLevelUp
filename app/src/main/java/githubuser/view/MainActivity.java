package githubuser.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import com.example.jakanakiwanuka.mrmlevelup.R;

import java.util.ArrayList;

import githubuser.model.GithubUsers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<GithubUsers> Users = new ArrayList<>();

    static {
        Users.add(new GithubUsers("James", "James Org"));
        Users.add(new GithubUsers("Leather Face", "Murder Inc"));
        Users.add(new GithubUsers("Jason", "Murder Inc"));
        Users.add(new GithubUsers("Mr Tickles", "Isle Of Perpetual Tickling"));
        Users.add(new GithubUsers("Bust a shot", "HARAM"));
        Users.add(new GithubUsers("Insanity", "Aren't we all"));
        Users.add(new GithubUsers("ISSSS", "Was?"));
        Users.add(new GithubUsers("your", "my"));
        Users.add(new GithubUsers("friend", "Henemy"));
        Users.add(new GithubUsers("Nyaahhhhclea", "I don know"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.users_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new GitHubAdaptor(Users, this);
        mRecyclerView.setAdapter(mAdapter);
    }


}
