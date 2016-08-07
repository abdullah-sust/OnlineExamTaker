package com.test.muhammadabdullah.examtakeronline;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ShowResult extends ActionBarActivity implements LoaderClassListener
{
    String user =  MainActivity.reg_no;
    String u2 = MainActivity.a+"ResultParse?User="+user;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        //Toast.makeText(ShowResult.this, user, Toast.LENGTH_LONG).show();
        parse_result();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void parse_result()
    {
        t1 = (TextView) findViewById(R.id.name);
        t2 = (TextView) findViewById(R.id.mark);
        new loader(u2,ShowResult.this).start();
    }
    public void getResponse(final String response)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                if(response.trim().equals("Result Not found"))
                {
                    t1.setText("Unknown");
                    t2.setText("Unknown");
                }
                else
                {
                    try
                    {
                        JSONArray jArray = new JSONArray(response);
                        for(int i=0; i<jArray.length(); i++)
                        {
                            JSONObject json_data = jArray.getJSONObject(i);
                            t1.setText(user);
                            t2.setText(json_data.getString("Result"));
                            break;
                        }
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }


            }
        });
    }
}

