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
        Users.add(new GitHubUsers("lkajbsdkjasd"));
        Users.add(new GitHubUsers("lkajbsdkjasd"));
        Users.add(new GitHubUsers("lkajbsdkjasd"));
        Users.add(new GitHubUsers("lkajbskjkknbmnmdkjasd"));
        Users.add(new GitHubUsers("lkajbsdkjasd"));
        Users.add(new GitHubUsers("ljkhbkhbsd"));
        Users.add(new GitHubUsers("lkajbsdkjasd"));
        Users.add(new GitHubUsers("lkajbsdkjasd"));
        Users.add(new GitHubUsers("lkajbsdmjhjhkjasd"));
        Users.add(new GitHubUsers("lkajbsdkjasd"));

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
