package com.example.jakanakiwanuka.mrmlevelup.view;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.jakanakiwanuka.mrmlevelup.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import githubuser.model.GithubUsers;
import githubuser.view.DetailActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * UI test for the Detail Activty class.
 */
@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

    private static final GithubUsers MOCKUSER =
            new GithubUsers("profileImage", "username",
                    "organizationUrl");

    @Rule
    public IntentsTestRule<DetailActivity> mDetailActivityTestRule =
            new IntentsTestRule<>(DetailActivity.class, true, false);

    /**
     * Setup for the UI test that caters to the User class instance created.
     */
    @Before
    public void intentWithUser() {
        Intent mockIntent = new Intent();
        mockIntent.putExtra("githubImage", MOCKUSER.getProfileImage());
        mockIntent.putExtra("githubUser", MOCKUSER.getUserName());
        mockIntent.putExtra("userOrg", MOCKUSER.getOrganizationUrl());
        mDetailActivityTestRule.launchActivity(mockIntent);
    }

    /**
     * Method to check that the assert created actually contains the created data.
     */
    @Test
    public void userDetailsDisplayed() {
        onView(withId(R.id.userName)).check(matches(withText("username")));
        onView(withId(R.id.organisation)).check(matches(withText("organizationUrl")));
    }

}
