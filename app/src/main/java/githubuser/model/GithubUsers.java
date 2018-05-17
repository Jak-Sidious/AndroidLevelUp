package githubuser.model;

import com.google.gson.annotations.SerializedName;

public class GithubUsers {

    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String profileImage;

    @SerializedName("organization_url")
    private String organizationUrl;

    public GithubUsers(String profileImage, String username, String organizationUrl){
        this.profileImage=profileImage;
        this.username=username;
        this.organizationUrl=organizationUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getUserName() {
        return username;
    }

    public String getOrganizationUrl() {
        return organizationUrl;
    }
}
