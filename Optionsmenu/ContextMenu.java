package com.example.lab;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

        Button b1 = (Button) findViewById(R.id.b1);
        registerForContextMenu(b1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.option_menu,menu);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        String title = item.getTitle().toString();
        switch (title) {
            case "Option 1":
                Toast.makeText(this, "Option 1", Toast.LENGTH_SHORT).show();
                break;
            case "Option 2":
                Toast.makeText(this, "Option 2", Toast.LENGTH_SHORT).show();
                break;
            case "Option 3":
                Toast.makeText(this, "Option 3", Toast.LENGTH_SHORT).show();
                break;
            case "Option 4":
                Toast.makeText(this, "Option 4", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}
