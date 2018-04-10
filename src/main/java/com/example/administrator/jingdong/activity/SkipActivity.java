package com.example.administrator.jingdong.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.jingdong.R;

public class SkipActivity extends AppCompatActivity {
    private int i=3;
    private TextView mTime;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    i--;
                    mTime.setText(i + "s");
                    if (i > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);
                    } else {
                        //跳转到主界面
                        goHome();
                    }
            }
            super.handleMessage(msg);
        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTime = (TextView) findViewById(R.id.tv_time);

        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message, 1000);
    }
    private void goHome() {
        Intent intent = new Intent(SkipActivity.this, ZongActivity.class);
        startActivity(intent);
        finish();
    }


}

