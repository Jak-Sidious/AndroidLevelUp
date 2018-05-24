package githubuser.model;

import com.google.gson.annotations.SerializedName;

/**
 * A Class is a way to create multiple objects.
 * @author Jakana Kiwanuka
 */
public class GithubUsers {
/**
 *Model for the Data to be received from github.
 */
    @SerializedName("login")
    private final String username; //tochange

    @SerializedName("avatar_url")
    private final String profileImage; //tochange

    @SerializedName("organizations_url")
    private final String organizationUrl; //tochange

    /**
     * Create the github users object based on the parameters.
     * @param profileImage The Github User Image
     * @param username The github Userrname
     * @param organizationUrl The Url for the GitHub User's organizations
     */
    public GithubUsers(String profileImage, String username, String organizationUrl) {
        this.profileImage = profileImage;
        this.username = username;
        this.organizationUrl = organizationUrl;
    }

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
}
