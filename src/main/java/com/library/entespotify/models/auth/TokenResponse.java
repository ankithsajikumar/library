package com.library.entespotify.models.auth;

import java.io.Serializable;
import java.util.List;

public class TokenResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String accessToken;
    private String refreshToken;
    private String username;
    private List<String> roles;

    public TokenResponse(String accessToken, String refreshToken, String username, List<String> roles) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.username = username;
        this.roles = roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
