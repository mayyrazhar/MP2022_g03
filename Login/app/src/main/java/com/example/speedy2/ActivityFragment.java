package com.example.speedy2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ActivityFragment extends Fragment {

    private Button carBookingHistory;
    private Button scooterBookingHistory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity,container,false);
        carBookingHistory = view.findViewById(R.id.btnh_carbh);
        scooterBookingHistory = view.findViewById(R.id.btnh_scooterbh);

        carBookingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),BookingHistory.class));
            }
        });

        scooterBookingHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),BookingHistory_Scooter.class));
            }
        });

        return view;
    }
}
