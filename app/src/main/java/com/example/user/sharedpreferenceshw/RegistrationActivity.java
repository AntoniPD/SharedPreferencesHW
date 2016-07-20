package com.example.user.sharedpreferenceshw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText edtRegUserName;
    EditText edtRegPass;
    EditText edtConfPass;
    Button btnReg;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final SharedPreferences sp = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        edtRegUserName = (EditText) findViewById(R.id.edt_reg_username);
        edtRegPass = (EditText) findViewById(R.id.edt_reg_pass);
        edtConfPass = (EditText) findViewById(R.id.edt_confpass);
        btnReg = (Button) findViewById(R.id.btn_reg);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameReg = String.valueOf(edtRegUserName);
                String passwordReg = String.valueOf(edtRegPass);
                String confPassword = String.valueOf(edtConfPass);

                if(passwordReg.equals(confPassword)){
                    editor.putString(usernameReg,usernameReg);
                    editor.putString(passwordReg,passwordReg);
                    editor.commit();
                    Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
