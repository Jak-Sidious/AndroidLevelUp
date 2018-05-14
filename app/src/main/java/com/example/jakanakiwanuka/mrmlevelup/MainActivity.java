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
        Users.add(new GitHubUsers("James"));
        Users.add(new GitHubUsers("Leather Face"));
        Users.add(new GitHubUsers("Jason"));
        Users.add(new GitHubUsers("Mr Tickles"));
        Users.add(new GitHubUsers("Bust a shot"));
        Users.add(new GitHubUsers("Insanity"));
        Users.add(new GitHubUsers("ISSSS"));
        Users.add(new GitHubUsers("your"));
        Users.add(new GitHubUsers("friend"));
        Users.add(new GitHubUsers("Nyaahhhhclea"));

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
