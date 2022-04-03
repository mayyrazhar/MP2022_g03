package com.example.speedy2;

public class UserProfile {
    public String userAge;
    public String userEmail;
    public String userName;

    public UserProfile(){

    }

    public UserProfile(String userAge, String userEmail, String userName) {
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getAge() {
        return userAge;
    }

    public void setAge(String age) {
        userAge = age;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setEmail(String email) {
        userEmail = email;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        userName = name;
    }
}
