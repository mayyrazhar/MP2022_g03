package com.example.speedy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class popupReserveDate_Scooter extends AppCompatActivity {

    DatePicker datePicker;
    Button confirmRes;

    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_reserve_date_scooter);

        datePicker = findViewById(R.id.dpReserveDate);
        confirmRes = findViewById(R.id.btn_confirmRes);

        confirmRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth()+1;
                int year = datePicker.getYear();

                date = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);

                Toast.makeText(getBaseContext(), "result : " + date, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent (popupReserveDate_Scooter.this,scooterBooking.class);
                intent.putExtra("keydate",date);
                startActivity(intent);

            }
        });

    }
}