package presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import githubuser.presenter.GithubUsersPresenter;
import githubuser.service.GithubService;
import githubuser.view.MainActivity;

/**
 * Test to cater to the GitHubUsersPresenter.
 */
@RunWith(MockitoJUnitRunner.class)
public class GithubUsersPresenterTest {
    @Mock
    public MainActivity mActivity;

    @Mock
    private GithubService mGitService;

    private GithubUsersPresenter mPresenter;

    /**
     * SetupFunction for the GithubUserPresenterTest.
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new GithubUsersPresenter(mActivity);
    }

    /**
     * Initial Test in the GithubUserPresnterTest.
     */
    @Test
    public void getUsersFromApiAndLoadIntoRecyclerView() {
        mPresenter.getGithubUsers();
    }



}
