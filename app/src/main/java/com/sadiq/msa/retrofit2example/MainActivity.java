package com.sadiq.msa.retrofit2example;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "9Q6PC6F26EO9MWLK";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv = (TextView) findViewById(R.id.Maintextid);

        BackgroundTask task= new BackgroundTask();
        task.execute();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private class BackgroundTask extends AsyncTask <Void,Void,Freemusicpojo>{

    Retrofit retrofit;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://freemusicarchive.org/api/get/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        @Override
//        Freemusicpojo
        protected Freemusicpojo doInBackground(Void... params) {
            Apiservice service = retrofit.create(Apiservice.class);
            Call<Freemusicpojo> call = service.getDataset(API_KEY);
            call.enqueue(new Callback<Freemusicpojo>() {
                @Override
                public void onResponse(Response<Freemusicpojo> response, Retrofit retrofit) {
//                    response:Response@4024
                    // Get result Repo from response.body()

                    String str="";
//                    str:"Not Found";
                    try {
                        str=response.errorBody().string();
//                        str:"Not Found"response:Response@4024
                    }catch (IOException e){

                    }
                    Toast.makeText(getApplicationContext(),
                            response.body().toString(), Toast.LENGTH_SHORT);
                    Log.d("Response Success", "onResponse:"+response.body());
                    tv.setText(response.body().toString());
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("Response Failure", "onResponse:"+t.getMessage());

                }
            });


//            Apiservice methods = restAdapter.create(IApiMethods.class);
//            Curator curators = methods.getCurators(API_KEY);
//            Apiservice service = retrofit.create(Apiservice.class);
//            Freemusicpojo freemusicpojos = service.getFreemusicpojo(API_KEY);
//            freemusicpojos
            return null;

        }

        @Override
        protected void onPostExecute(Freemusicpojo freemusicpojos) {
            super.onPostExecute(freemusicpojos);
                        Log.d("response", "helo");

//            Log.d("response", freemusicpojos.toString());
            tv.setText(freemusicpojos.title + "\n\n");
            for (Freemusicpojo.Dataset dataset : freemusicpojos.dataset) {
                tv.setText(tv.getText() + dataset.curator_title +
                        " - " + dataset.curator_tagline + "\n");
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
