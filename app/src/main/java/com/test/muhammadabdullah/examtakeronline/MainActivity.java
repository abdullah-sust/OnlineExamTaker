package com.test.muhammadabdullah.examtakeronline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderClassListener
{
    public static String u_nam,pas,a="http://192.168.43.79:15000/OnlineExam/",t=null;
    public static String reg_no;
    EditText e1,e2,r1;
    boolean r = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void res(View v)
    {
        r1 = (EditText) findViewById(R.id.user_name);
        reg_no = r1.getText().toString();
        if(reg_no.equals(""))
        {
            Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent it = new Intent(this,ShowResult.class);
            startActivity(it);
        }

    }
    public  void login(View v)
    {
        r = false;
        e1 = (EditText) findViewById(R.id.name);
        u_nam = e1.getText().toString();
        e2 = (EditText) findViewById(R.id.pass);
        pas = e2.getText().toString();
        if(u_nam.equals("") || pas.equals(""))
        {
            Toast.makeText(MainActivity.this,"Empty",Toast.LENGTH_LONG).show();
        }
        else
        {
            String uri;
            uri=a+"UserIdParse?"+"user="+u_nam+"&pass="+pas;
            new loader(uri,MainActivity.this).start();
        }

    }
    public  void register(View v)
    {
        r = true;
        reg1();
    }
    public void reg1()
    {
        e1 = (EditText) findViewById(R.id.name);
        u_nam = e1.getText().toString();
        e2 = (EditText) findViewById(R.id.pass);
        pas = e2.getText().toString();
        String uri;
        if(t==null)
            uri = a+"UserIdParse?"+"user="+u_nam+"&pass="+pas;
        else
        {
            uri = t;
            t = null;
        }
        new loader(uri,MainActivity.this).start();
    }
    public void m_choice()
    {
        Intent i = new Intent(this,Choice.class);
        startActivity(i);
    }
    @Override
    public void getResponse(final String response)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                if(response.trim().equals("logged in") && !r)
                {
                    Toast.makeText(MainActivity.this,"Logged in Successfully",Toast.LENGTH_LONG).show();
                    m_choice();
                    r = false;
                }
                else
                if(!r)
                {
                    Toast.makeText(MainActivity.this,"Not Logged In" + response,Toast.LENGTH_LONG).show();
                    r = false;
                }
                if(response.trim().equals("no data found") && r)
                {
                    t = a+ "UserIdInsert?" + "id="+"1"+"&name="+u_nam+"&pass="+pas;
                    reg1();
                    Toast.makeText(MainActivity.this,"registrationSuccessfull",Toast.LENGTH_LONG).show();
                    r=false;
                }
                else if(r)
                {
                    Toast.makeText(MainActivity.this,"name/passAlreadyExisted ",Toast.LENGTH_LONG).show();
                    r = false;
                }
            }
        });
    }
}
