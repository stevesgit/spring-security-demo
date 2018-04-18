package cn.steve.security.core.properties;

/**
 * Created By SteveWoo
 */
public class BrowserProperties {
    private String loginPage = "/login.html";
    private String hehe;
    private LoginResponseType loginType = LoginResponseType.JSON;
    private int rememberMeSeconds = 3600;

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }

    public String getHehe() {
        return hehe;
    }

    public void setHehe(String hehe) {
        this.hehe = hehe;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }
}
