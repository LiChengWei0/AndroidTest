package com.example.androidtest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingCartActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout ll_title;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        ll_title = findViewById(R.id.ll_title);
        TextView tv_title = new TextView(this);
        tv_title.setText("这是一个标题");
        tv_title.setTextSize(20);
        tv_title.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0);
        tv_title.setLayoutParams(params);
        tv_title.setGravity(Gravity.CENTER);
        tv_title.setBackgroundColor(Color.GREEN);
        ll_title.addView(tv_title);
    }

    @Override
    protected void onResume() {
        registerForContextMenu(ll_title);
        super.onResume();
    }

    @Override
    protected void onPause() {
        unregisterForContextMenu(ll_title);
        super.onPause();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
        getMenuInflater().inflate(R.menu.menu,menu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.menu_one) {
            Toast.makeText(this,"one",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menu_two) {
            Toast.makeText(this,"two",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    @Override
    public void onClick(View v) {

    }
}
