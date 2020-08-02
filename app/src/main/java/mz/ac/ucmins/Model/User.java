package mz.ac.ucmins.Model;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("visible_ids")
    @Expose
    private boolean visibleIds;
    @SerializedName("linked_contact_uid")
    @Expose
    private String linkedContactUid;
    @SerializedName("authenticated")
    @Expose
    private boolean authenticated;
    @SerializedName("api_url")
    @Expose
    private String apiUrl;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;
    @SerializedName("home_page")
    @Expose
    private String homePage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("wysiwyg_editor")
    @Expose
    private String wysiwygEditor;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("error_log_update")
    @Expose
    private double errorLogUpdate;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("listed")
    @Expose
    private boolean listed;
    @SerializedName("groups")
    @Expose
    private List<String> groups = null;
    @SerializedName("portal_skin")
    @Expose
    private String portalSkin;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("login_time")
    @Expose
    private String loginTime;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("ext_editor")
    @Expose
    private boolean extEditor;
    @SerializedName("last_login_time")
    @Expose
    private String lastLoginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isVisibleIds() {
        return visibleIds;
    }

    public void setVisibleIds(boolean visibleIds) {
        this.visibleIds = visibleIds;
    }

    public String getLinkedContactUid() {
        return linkedContactUid;
    }

    public void setLinkedContactUid(String linkedContactUid) {
        this.linkedContactUid = linkedContactUid;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWysiwygEditor() {
        return wysiwygEditor;
    }

    public void setWysiwygEditor(String wysiwygEditor) {
        this.wysiwygEditor = wysiwygEditor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getErrorLogUpdate() {
        return errorLogUpdate;
    }

    public void setErrorLogUpdate(double errorLogUpdate) {
        this.errorLogUpdate = errorLogUpdate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public String getPortalSkin() {
        return portalSkin;
    }

    public void setPortalSkin(String portalSkin) {
        this.portalSkin = portalSkin;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isExtEditor() {
        return extEditor;
    }

    public void setExtEditor(boolean extEditor) {
        this.extEditor = extEditor;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

}
