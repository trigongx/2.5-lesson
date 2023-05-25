package com.example.a25_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
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
        TextView tv_welcome = findViewById(R.id.welcome);
        TextView tv_mini = findViewById(R.id.minitext);

        Button button = findViewById(R.id.button);
        EditText et_login = findViewById(R.id.login);
        EditText et_password = findViewById(R.id.password);



        button.setOnClickListener(view -> {
            String enteredLogin = et_login.getText().toString();
            String enteredPassword = et_password.getText().toString();

            if(enteredLogin.equals("admin") && enteredPassword.equals("admin")) {
                Toast.makeText(MainActivity.this,"Вы успешно вошли",Toast.LENGTH_SHORT).show();
                et_login.setVisibility(View.GONE);
                et_password.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
                tv_entrance.setVisibility(View.GONE);
                tv_mini.setVisibility(View.GONE);
                tv_welcome.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });
        et_login.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            }
        });
    }
}
