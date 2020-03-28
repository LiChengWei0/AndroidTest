package com.example.androidtest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidtest.adpter.PlanetAdpter;
import com.example.androidtest.bean.Planet;

import java.util.ArrayList;

public class BaseAdapterActivity extends AppCompatActivity {

    private ArrayList<Planet> planetArrayList;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_base_adapter);
        planetArrayList = Planet.getDefaultList();
        ListView listView = findViewById(R.id.lv_planet);
        PlanetAdpter planetAdpter = new PlanetAdpter(this,R.layout.item_list,planetArrayList,Color.WHITE);
        listView.setAdapter(planetAdpter);
        listView.setOnItemClickListener(new MyItemSelectedListener());
    }

    private class MyItemSelectedListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(BaseAdapterActivity.this, "kkk"+id, Toast.LENGTH_SHORT).show();
        }
    }
}
