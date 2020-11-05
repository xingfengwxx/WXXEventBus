package com.wangxingxing.wxxeventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wangxingxing.libdemo.sp.EventDispatcher;
import com.wangxingxing.myeventbus.EventBus;
import com.wangxingxing.myeventbus.Subscribe;
import com.wangxingxing.myeventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {


    private TextView tvMsg;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMsg = findViewById(R.id.tv_msg);
        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String msg) {
        tvMsg.setText("MyEventBus: \n" + msg);
    }
}