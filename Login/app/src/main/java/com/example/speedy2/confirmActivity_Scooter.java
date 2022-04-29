package com.example.speedy2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class confirmActivity_Scooter extends AppCompatActivity {

    String ifullname,iic,iphonenumber,ireservedate,iduration,iprice;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    double price;

    private TextView FullName;
    private TextView ic;
    private TextView phoneNumber;
    private TextView reserveDate;
    private TextView duration;
    private TextView displayprice;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_scooter);

        FullName = findViewById (R.id.tvh_fullname);
        ic = findViewById (R.id.tvh_ic);
        phoneNumber = findViewById (R.id.tvh_phoneNumber);
        reserveDate = findViewById (R.id.tvh_reserveDate);
        duration = findViewById (R.id.tvh_returnDate);
        confirm = findViewById (R.id.btnh_back);
        displayprice = findViewById(R.id.tvh_price);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        ifullname = getIntent().getStringExtra("keyfullname");
        iic = getIntent().getStringExtra("keyic");
        iphonenumber = getIntent().getStringExtra("keyphonenumber");
        ireservedate = getIntent().getStringExtra("keyreservedate");
        iduration = getIntent().getStringExtra("keyduration");

        FullName.setText("NAME : " + ifullname);
        ic.setText("IC. NO : " + iic);
        phoneNumber.setText("PHONE NUMBER : " + iphonenumber);
        reserveDate.setText("RESERVATION DATE : " + ireservedate);
        duration.setText("RESERVATION DURATION : " + iduration);


        if (iduration.equals("15 MINUTES")){
            price = 7.50;
        }else if (iduration.equals("30 MINUTES")){
            price = 15;
        }else if (iduration.equals("1 HOURS")){
            price = 30;
        }else if (iduration.equals("1 HOURS 15 MINUTES")){
            price = 37.5;
        }else if (iduration.equals("1 HOURS 30 MINUTES")){
            price = 45;
        }

        iprice = String.format("%.2f", price);
        displayprice.setText("RM "+iprice);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = firebaseDatabase.getReference("SCOOTER BOOKING INFO").child(firebaseAuth.getUid());
                BookingDatabaseScooter bd = new BookingDatabaseScooter(ifullname,iic,iphonenumber,ireservedate,iduration,iprice);

                databaseReference.setValue(bd);

                addNotification();
                finish();
                startActivity(new Intent(confirmActivity_Scooter.this,SecondActivity.class));
            }
        });

    }

    private void addNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.star_on)                          //Display Icon kecik
                .setContentTitle("Scooter Booking")                         //Title Notification
                .setContentText("Your booking has been process!");          //Text Message Notification

        //Bila click Notification, pergi ke mana
        Intent notificationIntent = new Intent(this, SecondActivity.class);

        //Call Notification
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}