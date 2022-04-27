package com.example.speedy2;

public class BookingDatabase {

    public String fullname,ic,phonenumber,cartype,carname,reservedate,duration,price;

    public BookingDatabase() {
    }

    public BookingDatabase(String fullname, String ic, String phonenumber, String cartype, String carname, String reservedate, String duration, String price) {
        this.fullname = fullname;
        this.ic = ic;
        this.phonenumber = phonenumber;
        this.cartype = cartype;
        this.carname = carname;
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

    public String getCartype() {
        return cartype;
    }

    public String getCarname() {
        return carname;
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

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public void setCarname(String carname) {
        this.carname = carname;
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
