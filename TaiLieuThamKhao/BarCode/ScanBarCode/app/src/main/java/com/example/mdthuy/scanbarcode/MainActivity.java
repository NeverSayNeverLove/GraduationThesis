package com.example.mdthuy.scanbarcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    Button btn_scan;
    TextView textViewShowResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_scan = (Button) findViewById(R.id.btn_scan);
        textViewShowResult = (TextView) findViewById(R.id.txtview_show_result);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator scanIntegrator = new IntentIntegrator(MainActivity.this);
                scanIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent in){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, in);

        if(scanningResult != null){
            String content = in.getStringExtra("SCAN_RESULT");
            String format = in.getStringExtra("SCAN_RESULT_FORMAT");
            textViewShowResult.setText("Content: " + content + ", Format: " + format);
            Toast.makeText(MainActivity.this, "Content: " + content + ", Format: " + format, Toast.LENGTH_LONG).show();
        }
    }
}
