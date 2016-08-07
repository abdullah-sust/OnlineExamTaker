package com.test.muhammadabdullah.examtakeronline;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by MUHAMMAD ABDULLAH on 8/29/2015.
 */
class loader extends  Thread
{
    private String url;
    private LoaderClassListener mainActivity;
    loader(String url,LoaderClassListener listener)
    {
        this.url=url;
        mainActivity=listener;
    }
    public void run()
    {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        try{
            final String response = client.execute(request,new BasicResponseHandler());
            mainActivity.getResponse(response);
        }
        catch(final Exception e)
        {

        }
    }
}
