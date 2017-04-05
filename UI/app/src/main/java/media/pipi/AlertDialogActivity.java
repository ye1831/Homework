package com.example.snowcheng.ui;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        builder.setView(R.layout.login);
        builder.create();
        builder.show();
    }
}
