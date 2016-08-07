package com.test.muhammadabdullah.examtakeronline;

import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;


public class ExamStart  extends ActionBarActivity implements LoaderClassListener
{

    int no=customAdaptar.pos;
    int your_ans[][] = new int[50][2];
    int actual_ans[] = new int[50];
    int score;
    String uri;

    boolean call= false;

    String q,o1,o2,o3,o4,ans,qn;
    String url=MainActivity.a+"Parsing?Id=";
    TextView t1,t2,t3,t4,t_id,t_q;
    RadioButton r1,r2,r3,r4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_start);
        t_id = (TextView) findViewById(R.id.t_id);
        t_q = (TextView) findViewById(R.id.t_q);

        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);

        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);
        //qn = getIntent().getStringExtra("id")
        initial();
        qn = Integer.toString(no);
        new loader(url+qn,ExamStart.this).start();
        //Toast.makeText(ExamStart.this,"hello_world", Toast.LENGTH_LONG).show();
    }

    public void initial()
    {
        for(int j = 0;j<50;++j)
        {
            your_ans[j][0] = 0;
            your_ans[j][1] = 0;
        }
        //Toast.makeText(ExamStart.this,Integer.toString(no) , Toast.LENGTH_LONG).show();
    }
    public void rb1()
    {

            if(your_ans[no][1] == 1)
            {
                r1.setClickable(true);
                r2.setClickable(true);
                r3.setClickable(true);
                r4.setClickable(true);
                r1.setChecked(true);
                r2.setClickable(false);
                r3.setClickable(false);
                r4.setClickable(false);
            }
            if(your_ans[no][1] == 2)
            {
                r1.setClickable(true);
                r2.setClickable(true);
                r3.setClickable(true);
                r4.setClickable(true);
                r2.setChecked(true);
                r1.setClickable(false);
                r3.setClickable(false);
                r4.setClickable(false);
            }
            if(your_ans[no][1] == 3)
            {
                r1.setClickable(true);
                r2.setClickable(true);
                r3.setClickable(true);
                r4.setClickable(true);
                r3.setChecked(true);
                r2.setClickable(false);
                r1.setClickable(false);
                r4.setClickable(false);
            }
            if(your_ans[no][1] == 4)
            {
                r1.setClickable(true);
                r2.setClickable(true);
                r3.setClickable(true);
                r4.setClickable(true);
                r4.setChecked(true);
                r2.setClickable(false);
                r3.setClickable(false);
                r1.setClickable(false);
            }
    }
    public void RBClicked1(View v)
    {
        if(your_ans[no][0]==0 && your_ans[no][1]==0)
        {
            your_ans[no][0]=1;
            your_ans[no][1]=1;
            rb1();
        }
    }

    public void RBClicked2(View v)
    {
        if(your_ans[no][0]==0 && your_ans[no][1]==0)
        {
            your_ans[no][0]=1;
            your_ans[no][1]=2;
            rb1();
        }
    }

    public void RBClicked3(View v)
    {
        if(your_ans[no][0]==0 && your_ans[no][1]==0)
        {
            your_ans[no][0]=1;
            your_ans[no][1]=3;
            rb1();
        }
    }

    public void RBClicked4(View v)
    {
        if(your_ans[no][0]==0 && your_ans[no][1]==0)
        {
            your_ans[no][0]=1;
            your_ans[no][1]=4;
            rb1();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_exam_start, menu);
        return true;
    }

    public void set_ans()
    {
    }
    public void Next(View v)
    {
        ++no;
        if(no<11)
        {
            set_ans();

            if(your_ans[no][0]==0)
            {
                r1.setClickable(true);
                r2.setClickable(true);
                r3.setClickable(true);
                r4.setClickable(true);
                r1.setChecked(false);
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
            }
            else
            {

                if(your_ans[no][1] == 1)
                {
                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r1.setChecked(true);
                    r1.setClickable(false);
                    r2.setClickable(false);
                    r3.setClickable(false);
                    r4.setClickable(false);
                }
                if(your_ans[no][1] == 2)
                {
                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r2.setChecked(true);
                    r1.setClickable(false);
                    r3.setClickable(false);
                    r4.setClickable(false);
                }
                if(your_ans[no][1] == 3)
                {
                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r3.setChecked(true);
                    r2.setClickable(false);
                    r1.setClickable(false);
                    r4.setClickable(false);
                }
                if(your_ans[no][1] == 4)
                {
                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r4.setChecked(true);
                    r2.setClickable(false);
                    r3.setClickable(false);
                    r1.setClickable(false);
                }
            }
            qn = Integer.toString(no);
            new loader(url+qn,ExamStart.this).start();
        }
        else
        {
            --no;
            Toast.makeText(ExamStart.this,"clickPrevious", Toast.LENGTH_LONG).show();
        }
    }
    public void Previous(View v)
    {
        --no;
        if(no>0)
        {

            set_ans();

            if(your_ans[no][0]==0 && your_ans[no][1]==0)
            {
                r1.setClickable(true);
                r2.setClickable(true);
                r3.setClickable(true);
                r4.setClickable(true);
                r1.setChecked(false);
                r2.setChecked(false);
                r3.setChecked(false);
                r4.setChecked(false);
            }
            else
            {
                if(your_ans[no][1] == 1)
                {


                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r1.setChecked(true);
                    r2.setClickable(false);
                    r3.setClickable(false);
                    r4.setClickable(false);



                }
                if(your_ans[no][1] == 2)
                {
                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r2.setChecked(true);
                    r1.setClickable(false);
                    r3.setClickable(false);
                    r4.setClickable(false);
                }
                if(your_ans[no][1] == 3)
                {
                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r3.setChecked(true);
                    r2.setClickable(false);
                    r1.setClickable(false);
                    r4.setClickable(false);
                }
                if(your_ans[no][1] == 4)
                {
                    r1.setClickable(true);
                    r2.setClickable(true);
                    r3.setClickable(true);
                    r4.setClickable(true);
                    r4.setChecked(true);
                    r2.setClickable(false);
                    r3.setClickable(false);
                    r1.setClickable(false);
                }

            }
            qn = Integer.toString(no);

            new loader(url+qn,ExamStart.this).start();
        }
        else
        {
            ++no;
            Toast.makeText(ExamStart.this,"clickNext", Toast.LENGTH_LONG).show();
        }
    }

    public void submit(View v)
    {
        score=0;
        for(int i=1;i<=10;++i)
        {
            if(your_ans[i][1]==actual_ans[i])
                ++score;
        }

        uri = MainActivity.a +"ResultInsert?username="+MainActivity.u_nam+"&result="+Integer.toString(score);
        new loader(uri,ExamStart.this).start();
        //Toast.makeText(ExamStart.this,uri, Toast.LENGTH_LONG).show();
        //Toast.makeText(ExamStart.this,"submitSuccessfull"+Integer.toString(score), Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    @Override
    public void getResponse(final String response)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                try
                {
                    JSONArray jArray = new JSONArray(response);
                    for(int i=0; i<jArray.length(); i++)
                    {
                        JSONObject json_data = jArray.getJSONObject(i);
                        String t= json_data.getString("Id");
                        t_id.setText("Ques-no:"+t);
                        t_q.setText(json_data.getString("Ques")+" i love my parents so much. Also loves my siblings. Respect my teachers. Try to submit myself to my creator.");
                        t1.setText(json_data.getString("Op1")+" i love my parents so much. Also loves my siblings. Respect my teachers. Try to submit myself to my creator.");
                        t2.setText(json_data.getString("Op2")+" i love my parents so much. Also loves my siblings. Respect my teachers. Try to submit myself to my creator.");
                        t3.setText(json_data.getString("Op3")+" i love my parents so much. Also loves my siblings. Respect my teachers. Try to submit myself to my creator.");
                        t4.setText(json_data.getString("Op4")+" i love my parents so much. Also loves my siblings. Respect my teachers. Try to submit myself to my creator.");
                        actual_ans[Integer.parseInt(t)] = Integer.parseInt(json_data.getString("Ans"));
                        break;
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
