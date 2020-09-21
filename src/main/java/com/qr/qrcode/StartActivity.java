package com.qr.qrcode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    public static TextView url;
    Button scanB, urlB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        url = findViewById(R.id.message);
        scanB = findViewById(R.id.scan);
        urlB = findViewById(R.id.visitUrl);
        scanB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        urlB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((url.getText().toString()).equals("SCANNED URL WILL BE DISPLAYED HERE")) {
                    Toast.makeText(StartActivity.this, "NOT VALID URL", Toast.LENGTH_SHORT).show();
                } else {
                    if (!url.getText().toString().startsWith("http://") && !url.getText().toString().startsWith("https://")) {
                        String str = "http://" + url.getText().toString();
                        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                        startActivity(browser);
                    } else {
                        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(url.getText().toString()));
                        startActivity(browser);
                    }


                }
            }
        });
    }
}