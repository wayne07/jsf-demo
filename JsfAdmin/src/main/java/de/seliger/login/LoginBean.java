package de.seliger.login;

public class LoginBean {
    
    private String user;
    private String password;

    protected String getUser() {
        return user;
    }

    protected void setUser( String user ) {
        this.user = user;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword( String password ) {
        this.password = password;
    }

}
