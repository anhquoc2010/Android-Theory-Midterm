package com.example.midterm_android.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.midterm_android.MainActivity;
import com.example.midterm_android.R;
import com.example.midterm_android.model.SinhVien;

public class LoginActivity extends AppCompatActivity {

    private Button buttonLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ProgressBar progressBar;
    private TextView textViewSignupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
        progressBar.setVisibility(ProgressBar.GONE);

        SinhVien sinhVien = (SinhVien) getIntent().getSerializableExtra("sinhvien");

        if (sinhVien != null) {
            String email = sinhVien.getEmail().toString();
            String password = sinhVien.getPassword().toString();
            editTextEmail.setText(email);
            editTextPassword.setText(password);
        }

        buttonLogin.setOnClickListener(v -> {
            String textEmail = editTextEmail.getText().toString();
            String textPassword = editTextPassword.getText().toString();

            //check if all the data are present
            if (TextUtils.isEmpty(textEmail)) {
                editTextEmail.setError("Please enter your email");
                editTextEmail.requestFocus();
            } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                editTextEmail.setError("Invalid email");
                editTextEmail.requestFocus();
            } else if (TextUtils.isEmpty(textPassword)) {
                editTextPassword.setError("Please enter your password");
                editTextPassword.requestFocus();
            } else {
                progressBar.setVisibility(android.view.View.VISIBLE);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("sinhVienNe", sinhVien);
                startActivity(intent);
            }
        });

        textViewSignupLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
        });
    }

    private void findViews() {
        buttonLogin = findViewById(R.id.button_login);
        editTextEmail = findViewById(R.id.editTextUserName_login);
        editTextPassword = findViewById(R.id.editTextPSWD_login);
        progressBar = findViewById(R.id.progressBarLogin);
        textViewSignupLink = findViewById(R.id.textView_register_link);
    }
}