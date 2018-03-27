package com.example.dengbijun.mythreadtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {

        TestClone testClone = new TestClone(50, 100);
        testClone.add(1000);

        Log.i(TAG, "TestClone: " + testClone.getResult());
        TestClone testClone1 = null;
        try {
            testClone1 = (TestClone) testClone.clone();
            Log.i(TAG, "TestClone1: " + testClone1.getResult());

            testClone1.setA(100);
            testClone1.setB(50);
            testClone1.add(43);

            Log.i(TAG, "TestClone: " + testClone.getResult());
            Log.i(TAG, "TestClone1: " + testClone1.getResult());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void clickI(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}

class TestClone implements Cloneable {
    private int a;
    private int b;
    private List<Integer> data = new ArrayList<>();

    public TestClone(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public List<Integer> getData() {
        return data;
    }

    public void add(int num) {
        data.add(num);
    }

    public String getResult() {
        return "a = " + a + ",b = " + b + ",data.size = " + data.size();
    }
}
