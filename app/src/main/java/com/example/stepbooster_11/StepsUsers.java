package com.example.stepbooster_11;

public class StepsUsers {
    private static String name,email;
    private String id;
    //private String email;
   // private String name;
    private String Password;
    public StepsUsers(String id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.Password = password;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
         this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public StepsUsers(String email,String name,String password){
        this.email=email;
        this.name=name;
        this.Password=password;
    }
    public StepsUsers(){
    }
    public String toString(){
        return this.id + "." + name + "- "+ email;
    }
}