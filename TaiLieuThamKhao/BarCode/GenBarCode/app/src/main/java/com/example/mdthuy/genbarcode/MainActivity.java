package com.example.mdthuy.genbarcode;

import android.graphics.Bitmap;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    Button generate_bc;
    ImageView bcImage;
    EditText edText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate_bc = (Button) findViewById(R.id.generate_bc);
        bcImage = (ImageView) findViewById(R.id.imageView);
        edText = (EditText) findViewById(R.id.editText);

        generate_bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edText.getText().toString();
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.CODE_128, 400, 200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    bcImage.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
