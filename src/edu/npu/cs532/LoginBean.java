package edu.npu.cs532;

import java.io.Serializable;

public class LoginBean implements Serializable {
	
    private String username = "";
    private String password = "";

    public String getUsername() {
        return (username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return (password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private SuggestionBean suggestion;

    public SuggestionBean getSuggestion() {
        return (suggestion);
    }

    public String login() {
        if (!username.equals("cs532")) {
            suggestion = SuggestionUtils.getSuggestionBean();
            return ("bad-name");
        } else if (!password.equals("cs532")) {
            suggestion = SuggestionUtils.getSuggestionBean();
            return ("bad-password");
        } else {
            return ("success");
        }
    }
}
