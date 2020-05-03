package com.example.lastonetest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scan_router_imi extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    int my_permision = 0;
    ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);


    }

    @Override
    public void handleResult(Result result) {
        dashboard.imi_id = result.getText();
        getFragmentManager().popBackStackImmediate();
        finish();
    }



    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},my_permision);

        }
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
