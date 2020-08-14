package com.dmi.layoutdesignapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OptionMenuActivity extends AppCompatActivity {
    private Button btnShowPopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
        btnShowPopUp = findViewById(R.id.btnShowPopUp);
        btnShowPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  PopupMenu popupMenu = new PopupMenu(WhatsMenuActivity.this, btnShowPopUp);
                //  popupMenu.getMenuInflater().inflate(R.menu.whatsapp_menu, popupMenu.getMenu());
                PopupMenu popupMenu = new PopupMenu(OptionMenuActivity.this, btnShowPopUp);
                popupMenu.getMenuInflater().inflate(R.menu.whatsapp_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.menu_next:
                                Toast.makeText(OptionMenuActivity.this, "Next option selected", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_prev:
                                Toast.makeText(OptionMenuActivity.this, "Previous option selected", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.whatsmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_broadcast:
                Toast.makeText(OptionMenuActivity.this, "Broadcast click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_group:
                Toast.makeText(OptionMenuActivity.this, "New Group click", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}