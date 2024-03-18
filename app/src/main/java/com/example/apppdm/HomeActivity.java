package com.example.apppdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        changeNumber();
        dialPhone();
        setAlarm();
    }

    private void changeNumber() {
        TextView number = (TextView) findViewById(R.id.num);
        Button plusButton = (Button) findViewById(R.id.plusButton);
        Button minusButton = (Button) findViewById(R.id.minusButton);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = Integer.parseInt(number.getText().toString());
                result++;

                number.setText(String.valueOf(result));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = Integer.parseInt(number.getText().toString());
                result--;

                number.setText(String.valueOf(result));
            }
        });
    }

    private void dialPhone() {
        TextView phone = (TextView) findViewById(R.id.inputPhone);
        Button dialPhoneButton = (Button) findViewById(R.id.dialPhoneButton);

        Intent i = new Intent(Intent.ACTION_DIAL);

        dialPhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setData(Uri.parse("tel:" + phone.getText().toString()));

                startActivity(i);
            }
        });
    }

    private void setAlarm() {
        TimePicker alarmPicker = (TimePicker) findViewById(R.id.inputAlarm);
        Button setAlarmButton = (Button) findViewById(R.id.alarmButton);

        alarmPicker.setIs24HourView(true);

        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Meu alarme");

        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra(AlarmClock.EXTRA_HOUR, alarmPicker.getHour());
                i.putExtra(AlarmClock.EXTRA_MINUTES, alarmPicker.getMinute());

                startActivity(i);
            }
        });
    }
}