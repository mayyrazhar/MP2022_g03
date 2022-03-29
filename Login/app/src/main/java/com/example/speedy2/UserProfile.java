package com.example.speedy2;

public class UserProfile {
    public String Age;
    public String Email;
    public String Name;

    public UserProfile(){

    }

    public UserProfile(String userAge, String userEmail, String userName) {
        this.Age = userAge;
        this.Email = userEmail;
        this.Name = userName;
    }
}
