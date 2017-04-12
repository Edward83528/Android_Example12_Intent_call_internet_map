package com.example.u0151051.intent_call_internet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewid();
    }

    void findviewid() {
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn1.setOnClickListener(c);
        btn2.setOnClickListener(c);
        btn3.setOnClickListener(c);
        btn4.setOnClickListener(c);
    }

    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    //建立 Uri實體裡面包含我們要連結的網址或事情,利用 startActivity開啟新對應的頁面或程式
                    //利用Intent(我要做什麼事,uri);
                    Uri uri = Uri.parse("https://tw.yahoo.com/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    break;
                case R.id.button2:
                    //叫出撥號程式
                    Uri uri2 = Uri.parse("tel:0938495021");
                    Intent intent2 = new Intent(Intent.ACTION_DIAL, uri2);
                    startActivity(intent2);
                    break;
                case R.id.button3:
                    //直接打電話出去
                    //要在 AndroidManifest.xml 中，加上<uses-permission id="android.permission.CALL_PHONE" />
                    Uri uri3 = Uri.parse("tel:0938495021");
                    Intent intent3 = new Intent(Intent.ACTION_CALL, uri3);
                    try {
                        startActivity(intent3);
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "號碼是空號", Toast.LENGTH_SHORT);
                    }
                    break;
                case R.id.button4:
                    //利用Intent(我要做什麼事,uri);
                    Uri uri4 = Uri.parse("geo:25.033791,121.564644");
                    Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);
                    startActivity(intent4);
                    break;
            }

        }
    };
}
