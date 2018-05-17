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
        Users.add(new GithubUsers("James", "James", "James Org"));
        Users.add(new GithubUsers("baln", "james ","Murder Inc"));
        Users.add(new GithubUsers("Jason", "james", "Murder Inc"));
        Users.add(new GithubUsers("Mr Tickles", "Mr tickles", "Isle Of Perpetual Tickling"));
        Users.add(new GithubUsers("Bust a shot", "HARAM","Haram"));
        Users.add(new GithubUsers("Insanity", "joker", "Aren't we all"));
        Users.add(new GithubUsers("ISSSS", "Was?","wasn't it"));
        Users.add(new GithubUsers("your", "my", "Ours"));
        Users.add(new GithubUsers("friend", "Henemy", "yass"));
        Users.add(new GithubUsers("Nyaahhhhclea", "I don know","Neither do i"));

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
