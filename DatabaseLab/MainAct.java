package com.example.db;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;   //create an instance of DatabaseHelper class

    EditText editName, editSurname, editMarks;
    Button btnAddData;
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

        myDb = new DatabaseHelper(this);    //this is going to call the constructor of this DatabaseHelper class.
        editName = findViewById(R.id.t1);
        editSurname = findViewById(R.id.t2);
        editMarks = findViewById(R.id.t3);
        btnAddData = (Button) findViewById(R.id.btn);

        AddData();
    }

    public void AddData()   {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick ( View v ) {
                boolean isInserted = myDb.insertData(editName.getText().toString(), editSurname.getText().toString(), editMarks.getText().toString());

                if(isInserted)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
