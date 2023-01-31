package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //code here
        this.loadProfile();
    }

    @Override
    protected void onDestroy(){
        this.saveProfile();
        super.onDestroy();
        //code here
    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        //code here
        TextView name = (TextView) this.findViewById(R.id.name_textview);
        TextView status = (TextView) this.findViewById(R.id.status_textview);
        String name_str = name.getText().toString();
        String status_str = status.getText().toString();
        String new_name = preferences.getString("name", name_str);
        String new_status = preferences.getString("status", status_str);
        name.setText(new_name);
        status.setText(new_status);

    }

    public void saveProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView name = (TextView) this.findViewById(R.id.name_textview);
        TextView status = (TextView) this.findViewById(R.id.status_textview);

        TextView nameView = findViewById(R.id.name_textview);
        editor.putString("name", name.getText().toString());
        editor.putString("status", status.getText().toString());

        //code here
        editor.apply();
    }

    public void onLaunchMainClicked(View view) {
        finish();
    }
}