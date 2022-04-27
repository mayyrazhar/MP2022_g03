package com.example.speedy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookingHistory_Scooter extends AppCompatActivity {

    private TextView FullName;
    private TextView ic;
    private TextView phoneNumber;
    private TextView reserveDate;
    private TextView duration;
    private TextView displayprice;
    private Button back;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history_scooter);

        FullName = findViewById (R.id.tvh_fullname);
        ic = findViewById (R.id.tvh_ic);
        phoneNumber = findViewById (R.id.tvh_phoneNumber);
        reserveDate = findViewById (R.id.tvh_reserveDate);
        duration = findViewById (R.id.tvh_returnDate);
        back = findViewById (R.id.btnh_back);
        displayprice = findViewById(R.id.tvh_price);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("SCOOTER BOOKING INFO").child(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                BookingDatabaseScooter ScooterDatabase = snapshot.getValue(BookingDatabaseScooter.class);

                FullName.setText("Name : "+ ScooterDatabase.getFullname());
                ic.setText("Ic.No : "+ ScooterDatabase.getIc());
                phoneNumber.setText("Phone Number : "+ ScooterDatabase.getPhonenumber());
                reserveDate.setText("Reserve Date : "+ ScooterDatabase.getReservedate());
                duration.setText("Duration : "+ ScooterDatabase.getDuration());
                displayprice.setText("Price : RM "+ ScooterDatabase.getPrice());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookingHistory_Scooter.this,SecondActivity.class));
            }
        });

    }
}