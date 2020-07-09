package com.example.demoretrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demoretrofit.retrofit.DataParcelable;
import com.example.demoretrofit.retrofit.InitRetrofit;
import com.example.demoretrofit.retrofit.getValue;

public class SecondActivity extends AppCompatActivity {
    @getValue("name")
    String name;
    @getValue("parcel")
    DataParcelable dataParcelable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        InitRetrofit.initValue(this);
        TextView textView = findViewById(R.id.tv_input);
        textView.setText(name);
        Log.e("输出======", ":" + textView.getText().toString().trim() + "------" + dataParcelable.toString());
    }
}
