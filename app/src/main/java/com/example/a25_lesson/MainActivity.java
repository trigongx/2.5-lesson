package com.example.a25_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_entrance = findViewById(R.id.entrance);
        TextView tv_welcome = findViewById(R.id.tv_welcome);
        TextView tv_mini = findViewById(R.id.tv_minitext);

        Button btn_enter = findViewById(R.id.button);
        EditText et_login = findViewById(R.id.et_login);
        EditText et_password = findViewById(R.id.et_password);

        et_login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_login.getText().toString().isEmpty()){
                    btn_enter.setBackgroundColor(Color.GRAY);
                }
                else{
                    btn_enter.setBackgroundColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_password.getText().toString().isEmpty()){
                    btn_enter.setBackgroundColor(Color.GRAY);
                }
                else{
                    btn_enter.setBackgroundColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



        btn_enter.setOnClickListener(view -> {
            String enteredLogin = et_login.getText().toString();
            String enteredPassword = et_password.getText().toString();

            if(enteredLogin.equals("admin") && enteredPassword.equals("admin")) {
                Toast.makeText(MainActivity.this,"Вы успешно вошли",Toast.LENGTH_SHORT).show();
                et_login.setVisibility(View.GONE);
                et_password.setVisibility(View.GONE);
                btn_enter.setVisibility(View.GONE);
                tv_entrance.setVisibility(View.GONE);
                tv_mini.setVisibility(View.GONE);
                tv_welcome.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
