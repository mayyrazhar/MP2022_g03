package com.example.speedy2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class carBooking extends AppCompatActivity {

    String ifullname,iic,iphonenumber,icartype,icarname,ireservedate,iduration;

    private EditText FullName;
    private EditText ic;
    private EditText phoneNumber;
    private Spinner carType;
    private Spinner carName;
    private ImageButton reserveDate;
    private EditText duration;
    private Button book;
    private TextView resDate;

    String [] TypeOfCar;
    String [] NameOfCar;

    int indexType;
    int indexName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_booking);


        FullName = findViewById (R.id.et_FullName);
        ic = findViewById (R.id.et_ic);
        phoneNumber = findViewById (R.id.et_phoneNumber);
        carType = findViewById (R.id.spinner_carType);
        carName = findViewById (R.id.spinner_carName);
        reserveDate = findViewById (R.id.ib_reserveDate);
        duration = findViewById (R.id.et_duration);
        book = findViewById (R.id.btn_book);
        resDate = findViewById(R.id.tv_resDate);

        TypeOfCar = getResources().getStringArray(R.array.TypeOfCarArray);
        NameOfCar = getResources().getStringArray(R.array.NameOfCarArray);

        ArrayAdapter <String> adapterTypeOfCar = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,TypeOfCar);
        ArrayAdapter <String> adapterNameOfCar = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,NameOfCar);

        carType.setAdapter(adapterTypeOfCar);
        carName.setAdapter(adapterNameOfCar);


        reserveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(carBooking.this,popupReserveDate.class));
            }
        });

        ireservedate = getIntent().getStringExtra("keydate");
        resDate.setText(ireservedate);

        carType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexType = adapterView.getSelectedItemPosition();
                icartype = TypeOfCar [indexType];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        carName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexName = adapterView.getSelectedItemPosition();
                icarname = NameOfCar [indexName];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifullname = FullName.getText().toString();
                iic = ic.getText().toString();
                iphonenumber = phoneNumber.getText().toString();

                iduration = duration.getText().toString();

                Intent intent = new Intent(carBooking.this,confirmActivity.class);

                intent.putExtra("keyfullname",ifullname);
                intent.putExtra("keyic",iic);
                intent.putExtra("keyphonenumber",iphonenumber);
                intent.putExtra("keycartype",icartype);
                intent.putExtra("keycarname",icarname);
                intent.putExtra("keyreservedate",ireservedate);
                intent.putExtra("keyduration",iduration);

                startActivity(intent);

            }
        });

    }
}