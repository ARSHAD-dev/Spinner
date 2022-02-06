package com.example.spinner;

import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
/*
create by arshad
 */

public class MainActivity extends AppCompatActivity {
    public final String TAG = "MainActivity";
    Spinner spn;
    TextView txt;
    String country[] = {"please select country", "India", "Brazil", "Bangaldesh", "Srilanka"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn = (Spinner) findViewById(R.id.spinner);
        txt = (TextView) findViewById(R.id.text);
        ArrayAdapter adb = new ArrayAdapter(this, android.R.layout.simple_list_item_1, country);
        adb.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spn.setAdapter(adb);
        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(getApplicationContext(), "NO DATA", Toast.LENGTH_SHORT).show();
                } else {
                    txt.setText("you have select" + country[position]);
                    Log.i(TAG, "onItemSelected: " + country[position]);
                    txt.setTextColor(Color.RED);
                    txt.setTextSize(26);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}