package com.example.speedy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        FullName = findViewById (R.id.tv_fullname);
        ic = findViewById (R.id.tv_ic);
        phoneNumber = findViewById (R.id.tv_phoneNumber);
        carType = findViewById (R.id.tv_carType);
        carName = findViewById (R.id.tv_carName);
        reserveDate = findViewById (R.id.tv_reserveDate);
        duration = findViewById (R.id.tv_returnDate);
        confirm = findViewById (R.id.btn_confirm);
        displayprice = findViewById(R.id.tv_price);

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
                bookingDatabase bd = new bookingDatabase(ifullname,iic,iphonenumber,icartype,icarname,ireservedate,iduration,iprice);

                databaseReference.setValue(bd);

                finish();
                startActivity(new Intent(confirmActivity.this,SecondActivity.class));
            }
        });

    }
}