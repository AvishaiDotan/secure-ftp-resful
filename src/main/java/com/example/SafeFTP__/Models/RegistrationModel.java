package com.example.SafeFTP__.Models;

public class RegistrationModel {
    private String ftpServer;
    private String username;
    private String password;
    private String token;

    // Constructor
    public RegistrationModel(String ftpServer, String username, String password, String token) {
        this.ftpServer = ftpServer;
        this.username = username;
        this.password = password;
        this.token = token;
    }

    // Getters and Setters
    public String getFtpServer() {
        return ftpServer;
    }

    public void setFtpServer(String ftpServer) {
        this.ftpServer = ftpServer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString method
    @Override
    public String toString() {
        return "FtpRegistrationModel{" +
                "ftpServer='" + ftpServer + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
