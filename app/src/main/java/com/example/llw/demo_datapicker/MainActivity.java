package com.example.llw.demo_datapicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TextView textView;
    private Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = (DatePicker) findViewById(R.id.data);
        textView = (TextView) findViewById(R.id.text);

        calendar = Calendar.getInstance();//获取当前的时间
        //显示当前的时间
        textView.setText("当前时间:"+calendar.get(Calendar.YEAR)+"月"+calendar.get(Calendar.MONTH)+"月"+
                calendar.get(Calendar.DAY_OF_MONTH)+"日");

        //注册监听事件，当日起改变时，更新textview的显示内容
        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textView.setText("当前时间："+year+"月"+monthOfYear+"月"+dayOfMonth+"日");
                    }
                });

    }


}
