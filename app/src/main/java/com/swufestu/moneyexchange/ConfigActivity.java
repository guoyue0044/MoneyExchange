package com.swufestu.moneyexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

import javax.security.auth.login.LoginException;

public class ConfigActivity extends AppCompatActivity {

    private static final String TAG = "ConfigActivity";
    private float dollarRate = 0.28f;
    private float euroRate = 0.21f;
    private float wonRate = 501f;

    EditText dollartext;
    EditText eurotext;
    EditText wontext;

    public EditText dollarText,euroText,wonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Intent intent = getIntent();
        float dollar2 = intent.getFloatExtra("dollar_rate_key",0.0f);
        float euro2 = intent.getFloatExtra("euro_rate_key",0.0f);
        float won2 = intent.getFloatExtra("won_rate_key",0.0f);

        Log.i(TAG, "onCreate: dollar2="+dollar2);
        Log.i(TAG, "onCreate: euro2="+euro2);
        Log.i(TAG, "onCreate: won2+"+won2);

        dollarText = (EditText) findViewById(R.id.dollar_rate);
        euroText = (EditText) findViewById(R.id.euro_rate);
        wonText = (EditText) findViewById(R.id.won_rate);

        //将汇率输入到控件中
        dollarText.setText(String.valueOf(dollar2));
        euroText.setText(String.valueOf(euro2));
        wonText.setText(String.valueOf(won2));

    }
    public void save(View btn){
        Log.i(TAG,"save:");
        //重新获取新的汇率数据
        float dollar = Float.parseFloat(dollarText.getText().toString());
        float euro = Float.parseFloat(euroText.getText().toString());
        float won = Float.parseFloat(wonText.getText().toString());

        Log.i(TAG, "save: dollar=" + dollar);
        Log.i(TAG, "save: euro=" + euro);
        Log.i(TAG, "save: won=" + won);

        Intent first = getIntent();
        first.putExtra("dollar_key",dollar);
        first.putExtra("euro_key",euro);
        first.putExtra("won_key",won);

        //startActivity(first);
        setResult(3,first);

        //返回到调用页面
        finish();

        SharedPreferences sharedPreferences = getSharedPreferences("myrate", Activity.MODE_PRIVATE);

        PreferenceManager.getDefaultSharedPreferences(this);

        dollarRate = sharedPreferences.getFloat("dollar_rate",0.0f);
        euroRate = sharedPreferences.getFloat("euro_rate",0.0f);
        wonRate = sharedPreferences.getFloat("won_Rate",0.0f);


    }
}