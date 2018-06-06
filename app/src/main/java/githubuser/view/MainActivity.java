package githubuser.view;



import android.graphics.Color;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jakanakiwanuka.mrmlevelup.R;
import java.util.ArrayList;
import java.util.List;

import githubuser.adapter.GitHubAdaptor;
import githubuser.model.GithubUsers;
import githubuser.presenter.GithubUsersPresenter;
import githubuser.util.NetworkConnectivity;


/**
 * Class that deals with the default data/activity shown when the app loads.
 * @author jakanakiwanuka
 */
public class MainActivity extends AppCompatActivity
        implements GithubUsersPresenter.View {

    RecyclerView mRecyclerView;
    SwipeRefreshLayout refreshLayout;
    RecyclerView.LayoutManager mLayoutManager;
    NetworkConnectivity networkConnectivity;
    Boolean isConnected;
    Snackbar snackbar;
    List<GithubUsers> users = new ArrayList();
    final GithubUsersPresenter presenter =
            new GithubUsersPresenter(this);
    static final  String ALL_KEYS = "list_state";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSwipeRefreshLayout();
        networkConnectivity = new NetworkConnectivity(this);
        isConnected = networkConnectivity.isWifiConnected();




        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList(ALL_KEYS);
            displayGitHubUsers(users);
        } else {
            if (isConnected) {
                presenter.getGithubUsers();
            } else {
                displaySnackBar(refreshLayout, R.string.no_connection, users);
            }

        }
    }

    /**
     * Function to display the snackbar.
     * @param swipeRefreshLayout Constantly run until a connection is recieved
     * @param internetStatus a determinant of internet state
     * @param users array of user data
     */
    public void displaySnackBar(final SwipeRefreshLayout swipeRefreshLayout, int internetStatus,
                                final List<GithubUsers> users) {

        CharSequence actionText = "CLOSE";

        if (users == null) {
            actionText = "TRY AGAIN";
        }

        snackbar = Snackbar
                .make(swipeRefreshLayout, internetStatus, Snackbar.LENGTH_INDEFINITE)
                .setAction(actionText, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (users != null) {
                            snackbar.dismiss();
                        } else {
                            presenter.getGithubUsers();
                        }
                    }

                });
        //Change text color for action button
        snackbar.setActionTextColor(Color.CYAN);

        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);

        snackbar.show();

    }

    /**
     * Method to deal with the swipe to refresh functionality.
     */
    private void setSwipeRefreshLayout() {
        refreshLayout = findViewById(R.id.swipe_layout);
        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                displayGitHubUsers(users);
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        refreshLayout.setRefreshing(false);

                    }
                }, 3000);
            }
        });
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
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter adapter = new GitHubAdaptor(users, this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
