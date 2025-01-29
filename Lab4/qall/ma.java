package com.example.inputcontrols;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleBtn);
        toggleButton.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if(isChecked)   Toast.makeText(MainActivity.this, "Toggle ON", Toast.LENGTH_SHORT).show();
            else Toast.makeText(MainActivity.this, "Toggle OFF", Toast.LENGTH_SHORT).show();
        }));

        ToggleButton t2 = (ToggleButton) findViewById(R.id.toggleButton2);
        t2.setText("Mobile Data");
        t2.setTextOn("Wi-Fi");
        t2.setTextOff("Mobile Data");

        t2.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if(isChecked)   Toast.makeText(MainActivity.this, "Wi-Fi", Toast.LENGTH_SHORT).show();
            else Toast.makeText(MainActivity.this, "Mobile Data", Toast.LENGTH_SHORT).show();
        }));


        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, "V1", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, "V2", Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, "V3", Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this, "V4", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
