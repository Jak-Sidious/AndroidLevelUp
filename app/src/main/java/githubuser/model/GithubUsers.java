package githubuser.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * A Class is a way to create multiple objects.
 * @author Jakana Kiwanuka
 */
public class GithubUsers implements Parcelable {
    /**
     * Model for the Data to be received from github.
     */
    @SerializedName("login")
    private final String username; //tochange

    @SerializedName("avatar_url")
    private final String profileImage; //tochange

    @SerializedName("organizations_url")
    private final String organizationUrl; //tochange

    /**
     * Create the github users object based on the parameters.
     *
     * @param profileImage    The Github User Image
     * @param username        The github Userrname
     * @param organizationUrl The Url for the GitHub User's organizations
     */
    public GithubUsers(String profileImage, String username, String organizationUrl) {
        this.profileImage = profileImage;
        this.username = username;
        this.organizationUrl = organizationUrl;
    }

    /**
     * method to read string data after a change in orientation.
     *
     * @param in parcel data
     */
    public GithubUsers(Parcel in) {
        username = in.readString();
        profileImage = in.readString();
        organizationUrl = in.readString();
    }

    public static final Creator<GithubUsers> CREATOR = new Creator<GithubUsers>() {
        @Override
        public GithubUsers createFromParcel(Parcel source) {
            return new GithubUsers(source);
        }

            @Override
            public GithubUsers[] newArray(int size) {
                return new GithubUsers[size];
            }
        };

        /**
         * Getter method for Profile Image.
         * @return profileImage
         */
        public String getProfileImage() {
            return profileImage;
        }

        /**
         * Getter method for Username.
         * @return username
         */
        public String getUserName() {
            return username;
        }

        /**
         * Getter method for OrganizationUrl.
         * @return organizationUrl
         */
        public String getOrganizationUrl() {
            return organizationUrl;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(username);
            dest.writeString(profileImage);
            dest.writeString(organizationUrl);
        }
    }

