package com.example.speedy2;

import androidx.appcompat.app.AppCompatActivity;

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

    int nDuration;
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

        FullName = findViewById (R.id.tv_fullname);
        ic = findViewById (R.id.tv_ic);
        phoneNumber = findViewById (R.id.tv_phoneNumber);
        reserveDate = findViewById (R.id.tv_reserveDate);
        duration = findViewById (R.id.tv_returnDate);
        confirm = findViewById (R.id.btn_confirm);
        displayprice = findViewById(R.id.tv_price);

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
        duration.setText("RESERVATION DURATION : " + iduration+" Hour(s)");

        nDuration = Integer.parseInt(iduration);

        price = nDuration*30;

        iprice = String.format("%.2f", price);
        displayprice.setText("RM "+iprice);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference = firebaseDatabase.getReference("SCOOTER BOOKING INFO").child(firebaseAuth.getUid());
                bookingDatabase_Scooter bd = new bookingDatabase_Scooter(ifullname,iic,iphonenumber,ireservedate,iduration,iprice);

                databaseReference.setValue(bd);

                finish();
                startActivity(new Intent(confirmActivity_Scooter.this,SecondActivity.class));
            }
        });

    }
}