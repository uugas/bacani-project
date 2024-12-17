package com.example.bacani;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Vibrator v;

    ListView lv;


    ArrayList<Integer> num;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        v = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        lv = findViewById(R.id.list);

        num  = new ArrayList<Integer>();


        for (int i = 0; i < 100; i++) {
            num.add(i);
        }


        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, num);


        lv.setAdapter(adapter);


        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int i) {
                Log.i("a", "scrolling stopped... ");
            }

            @Override
            public void onScroll(AbsListView view, int i, int i1, int i2) {
                v.vibrate(10);
                Log.i("a", "scrolling... ");
            }



        });

    }
}