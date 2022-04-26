package com.example.speedy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class scooterBooking extends AppCompatActivity {

    String ifullname,iic,iphonenumber,ireservedate,iduration;

    private EditText FullName;
    private EditText ic;
    private EditText phoneNumber;
    private ImageButton reserveDate;
    private EditText duration;
    private Button book;
    private TextView resDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scooter_booking);

        FullName = findViewById (R.id.et_FullName);
        ic = findViewById (R.id.et_ic);
        phoneNumber = findViewById (R.id.et_phoneNumber);
        reserveDate = findViewById (R.id.ib_reserveDate);
        duration = findViewById (R.id.et_duration);
        book = findViewById (R.id.btn_book);
        resDate = findViewById(R.id.tv_resDate);

        reserveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(scooterBooking.this,popupReserveDate_Scooter.class));
            }
        });

        ireservedate = getIntent().getStringExtra("keydate");
        resDate.setText(ireservedate);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ifullname = FullName.getText().toString();
                iic = ic.getText().toString();
                iphonenumber = phoneNumber.getText().toString();

                iduration = duration.getText().toString();

                Intent intent = new Intent(scooterBooking.this,confirmActivity_Scooter.class);

                intent.putExtra("keyfullname",ifullname);
                intent.putExtra("keyic",iic);
                intent.putExtra("keyphonenumber",iphonenumber);
                intent.putExtra("keyreservedate",ireservedate);
                intent.putExtra("keyduration",iduration);

                startActivity(intent);

            }
        });
    }
}