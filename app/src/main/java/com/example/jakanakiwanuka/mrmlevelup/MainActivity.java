package com.example.jakanakiwanuka.mrmlevelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import adapter.GitHubAdaptor;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<GitHubUsers> Users = new ArrayList<>();

    static {
        Users.add(new GitHubUsers("James", "James Org"));
        Users.add(new GitHubUsers("Leather Face", "Murder Inc"));
        Users.add(new GitHubUsers("Jason", "Murder Inc"));
        Users.add(new GitHubUsers("Mr Tickles", "Isle Of Perpetual Tickling"));
        Users.add(new GitHubUsers("Bust a shot", "HARAM"));
        Users.add(new GitHubUsers("Insanity", "Aren't we all"));
        Users.add(new GitHubUsers("ISSSS", "Was?"));
        Users.add(new GitHubUsers("your", "my"));
        Users.add(new GitHubUsers("friend", "Henemy"));
        Users.add(new GitHubUsers("Nyaahhhhclea", "I don know"));

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
