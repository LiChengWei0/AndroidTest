package com.example.androidtest.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.androidtest.bean.Planet;

import java.util.ArrayList;

public class PlanetAdpter extends BaseAdapter {
    private ArrayList<Planet> planets;

    private LayoutInflater mInflater;
    private Context mContext;
    private int mLayoutId;
    private int mBackground;

    public PlanetAdpter(Context context, int layout_id, ArrayList<Planet> planet_list, int background) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mLayoutId = layout_id;
        planets = planet_list;
        mBackground = background;
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int position) {
        return planets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(mLayoutId, null);
            viewHolder.linearLayout = convertView.findViewById(R.id.ll_item);
            viewHolder.iv_planet = convertView.findViewById(R.id.iv_icon);
            viewHolder.tv_name = convertView.findViewById(R.id.tv_name);
            viewHolder.tv_desc = convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder)convertView.getTag();
        }
        Planet planet = planets.get(position);
        viewHolder.linearLayout.setBackgroundColor(mBackground);
        viewHolder.iv_planet.setImageResource(planet.image);
        viewHolder.tv_name.setText(planet.name);
        viewHolder.tv_desc.setText(planet.desc);
        return convertView;
    }

    public final class ViewHolder{
        private LinearLayout linearLayout;
        public ImageView iv_planet;
        public TextView tv_name;
        public TextView tv_desc;
    }
}
