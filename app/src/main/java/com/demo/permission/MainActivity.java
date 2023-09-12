package com.demo.permission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Button;

import com.example.demopermisson.R;

public class MainActivity extends AppCompatActivity {
    Button btnPer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPer = findViewById(R.id.btnPer);

        btnPer.setOnClickListener(v->{
            checkPermission();


        });
    }

    private void checkPermission() {
        if (!Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName())

            );
                startActivity(intent);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, PermissionTransparentActivity.class);
                    startActivity(intent);
                }
            },300);

        }
    }


}