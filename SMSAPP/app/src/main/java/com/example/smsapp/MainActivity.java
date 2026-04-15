package com.example.smsapp;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;

    ActivityResultLauncher<String> arl = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
        @Override
        public void onActivityResult(Boolean o) {
            SmsManager sm = SmsManager.getDefault();
            sm.sendTextMessage(et1.getText().toString(), null, et2.getText().toString(), null, null);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.mo);
        et2 = findViewById(R.id.msg);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arl.launch(Manifest.permission.SEND_SMS);
                arl.launch(Manifest.permission.RECEIVE_SMS);
                arl.launch(Manifest.permission.READ_SMS);

            }
        });
    }
}
