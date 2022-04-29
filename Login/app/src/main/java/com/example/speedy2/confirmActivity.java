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

public class confirmActivity extends AppCompatActivity {

    String ifullname,iic,iphonenumber,icartype,icarname,ireservedate,iduration,iprice;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    int nDuration;
    double price;

    private TextView FullName;
    private TextView ic;
    private TextView phoneNumber;
    private TextView carType;
    private TextView carName;
    private TextView reserveDate;
    private TextView duration;
    private TextView displayprice;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        FullName = findViewById (R.id.tvh_fullname);
        ic = findViewById (R.id.tvh_ic);
        phoneNumber = findViewById (R.id.tvh_phoneNumber);
        carType = findViewById (R.id.tvh_carType);
        carName = findViewById (R.id.tvh_carName);
        reserveDate = findViewById (R.id.tvh_reserveDate);
        duration = findViewById (R.id.tvh_returnDate);
        confirm = findViewById (R.id.btnh_back);
        displayprice = findViewById(R.id.tvh_price);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


        ifullname = getIntent().getStringExtra("keyfullname");
        iic = getIntent().getStringExtra("keyic");
        iphonenumber = getIntent().getStringExtra("keyphonenumber");
        icartype = getIntent().getStringExtra("keycartype");
        icarname = getIntent().getStringExtra("keycarname");
        ireservedate = getIntent().getStringExtra("keyreservedate");
        iduration = getIntent().getStringExtra("keyduration");

        FullName.setText("NAME : " + ifullname);
        ic.setText("IC. NO : " + iic);
        phoneNumber.setText("PHONE NUMBER : " + iphonenumber);
        carType.setText("CAR TYPE : " + icartype);
        carName.setText("CAR NAME : " + icarname);
        reserveDate.setText("RESERVATION DATE : " + ireservedate);
        duration.setText("RESERVATION DURATION : " + iduration+" Days");

        nDuration = Integer.parseInt(iduration);

        if (icarname.equals("FORTUNER")){
            price = nDuration*180;
        }else if (icarname.equals("X70")){
            price = nDuration*200;
        }else if (icarname.equals("MYVI")){
            price = nDuration*120;
        }else if (icarname.equals("VIVA")){
            price = nDuration*110;
        }else if (icarname.equals("BEZZA")){
            price = nDuration*120;
        }else if (icarname.equals("PERSONA")){
            price = nDuration*130;
        }else if (icarname.equals("NISSAN FRONTIER")){
            price = nDuration*230;
        }else if (icarname.equals("FORD RANGER")){
            price = nDuration*310;
        }

        iprice = String.format("%.2f", price);
        displayprice.setText("RM "+iprice);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference = firebaseDatabase.getReference("CARS BOOKING INFO").child(firebaseAuth.getUid());
                BookingDatabase bd = new BookingDatabase(ifullname,iic,iphonenumber,icartype,icarname,ireservedate,iduration,iprice);

                databaseReference.setValue(bd);

                addNotification();
                finish();
                startActivity(new Intent(confirmActivity.this,SecondActivity.class));
            }
        });
    }

    private void addNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.star_on)                   //Display Icon kecik
                .setContentTitle("Car Booking")                             //Title Notification
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