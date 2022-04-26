package com.example.speedy2;

public class bookingDatabase_Scooter {

    public String fullname, ic, phonenumber,reservedate, duration, price;

    public bookingDatabase_Scooter(String fullname, String ic, String phonenumber, String reservedate, String duration, String price) {
        this.fullname = fullname;
        this.ic = ic;
        this.phonenumber = phonenumber;
        this.reservedate = reservedate;
        this.duration = duration;
        this.price = price;
    }

    public String getFullname() {
        return fullname;
    }

    public String getIc() {
        return ic;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getReservedate() {
        return reservedate;
    }

    public String getDuration() {
        return duration;
    }

    public String getPrice() {
        return price;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setReservedate(String reservedate) {
        this.reservedate = reservedate;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
