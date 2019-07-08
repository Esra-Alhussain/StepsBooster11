package com.example.stepbooster_11;

public class User {

    private String email;
    private String username;
    private String password;
    private String confirmPassword;

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(){
        this.username=username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(){
        this.password=password;
    }
    public String getConfirmPassword(){
        return password;
    }
    public void setConfirmPassword(){
        this.confirmPassword=confirmPassword;
    }
    public User(String email,String password,String username,String confirmPassword){
        this.email=email;
        this.username=username;
        this.password=password;
        this.confirmPassword=confirmPassword;

    }
    public User(){

    }
}
