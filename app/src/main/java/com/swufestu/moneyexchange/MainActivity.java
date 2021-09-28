package com.swufestu.moneyexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActicity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void myclick(View btn){
        Log.i(TAG, "click: ");
        EditText RMB = findViewById(R.id.RMB);
        String inp = RMB.getText().toString();
        if(inp.length()>0){
            Log.i(TAG, "click: inp="+inp);
            float num = Float.parseFloat(inp);
            float r=0;
            if(RMB.getId()==R.id.DOLLAR){
                r = num*0.28f;
            }else if(RMB.getId()==R.id.EURO){
                r = num*0.21f;
            }else{
                r = num*501;
            }
            Log.i(TAG, "click: r="+r);
            //输出到控件
            TextView exchange = findViewById(R.id.exchange);
            exchange.setText(String.valueOf(r));
        }else{
            //重置输出
            TextView exchange = findViewById(R.id.exchange);
            exchange.setText(R.string.app_name);
            Toast.makeText(this,"请输入金额后再进行计算", Toast.LENGTH_SHORT).show();
        }
    }
    public void func(View v){
        Log.i(TAG, "func: myclick");
        //打开窗口
        Intent intent = new Intent(this,FirstActivity.class);
        startActivity(intent);
    }
}
