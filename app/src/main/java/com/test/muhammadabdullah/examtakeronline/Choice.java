package com.test.muhammadabdullah.examtakeronline;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class Choice extends ActionBarActivity {

    RadioButton c1,c2;
    TextView t1,t2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_choice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void but_sub(View v)
    {
        c1 = (RadioButton) findViewById(R.id.c1);
        c2 = (RadioButton) findViewById(R.id.c2);


        if(c1.isChecked()==false && c2.isChecked()==true)
        {
            Intent it = new Intent(this,ViewAll.class);
            startActivity(it);
        }
        else
        {
            Toast.makeText(Choice.this,"needAdminPermission", Toast.LENGTH_LONG).show();
        }
    }
}
