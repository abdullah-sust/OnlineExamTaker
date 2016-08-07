package com.test.muhammadabdullah.examtakeronline;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HP on 5/22/2015.
 */
public class customAdaptar extends BaseAdapter{
    Activity context;
    static int pos;

    int number;
    ArrayList<String>items;
    customAdaptar(Activity context ,ArrayList <String> items ){
        this.context= context;
        this.items= items;

    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView = context.getLayoutInflater().inflate(R.layout.listitam, parent , false);
            Button butt = (Button) convertView.findViewById(R.id.butt1);
            butt.setText("QUES"+items.get(position));
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    pos =position+1;

                    Intent i = new Intent(context, ExamStart.class);

                    context.startActivity(i);
                }
            });
        }

        return convertView;
    }
}
