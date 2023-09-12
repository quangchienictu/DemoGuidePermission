package com.demo.permission;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demopermisson.R;


public class PermissionTransparentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_permisson);
        WindowManager.LayoutParams layoutParams;
        layoutParams = new WindowManager.LayoutParams(2038, 4719872, -3);
        getWindow().setAttributes(layoutParams);

        RelativeLayout parent = findViewById(R.id.parent);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
        super.onPause();
    }


}