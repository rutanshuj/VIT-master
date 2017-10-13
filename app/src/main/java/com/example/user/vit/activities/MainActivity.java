package com.example.user.vit.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.vit.R;
import com.example.user.vit.activities.HomePage;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button button, b1, b2, b3;
    String response;
    EditText editText1, editText2;
    String regno, password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.regno);
        editText2 = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.login);
        b1 = (Button) findViewById(R.id.home);
        b2 = (Button) findViewById(R.id.mapbttn);
        b3 = (Button) findViewById(R.id.cgpa_btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home1Activity.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CGPACal.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                PostRequest request = new PostRequest();

                regno = editText1.getText().toString();
                password = editText2.getText().toString();

                try {
                    response = new PostRequest().execute("").get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject result = jsonObject.getJSONObject("result");
                    int code = result.getInt("code");

                    if (code == 200) {
                        Toast.makeText(getApplicationContext(),
                                "Successful Login", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(intent);
                    } else if (code == 500) {
                        Toast.makeText(getApplicationContext(),
                                "Incorrect credentials !", Toast.LENGTH_LONG).show();
                    } else if (code == 600) {
                        Toast.makeText(getApplicationContext(),
                                "The current session has timed out !", Toast.LENGTH_LONG).show();
                    } else if (code == 700) {
                        Toast.makeText(getApplicationContext(),
                                "The requested data could not be found !", Toast.LENGTH_LONG).show();
                    }else if (code == 800) {
                        Toast.makeText(getApplicationContext(),
                                "VIT servers are currently down. Kindly retry sometime later !", Toast.LENGTH_LONG).show();
                    }else if (code == 900) {
                        Toast.makeText(getApplicationContext(),
                                "Our servers are down for maintenance. Kindly bear with us!", Toast.LENGTH_LONG).show();
                    }else if (code == 1000) {
                        Toast.makeText(getApplicationContext(),
                                "Number of tries exceeded. Kindly limit it below 10 !", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "Kindly retry", Toast.LENGTH_LONG).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), response,
                        Toast.LENGTH_LONG).show();

                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

    public static String makePostRequest(String stringurl, String
            payload, Context context) throws IOException {

        URL url = new URL(stringurl);
        HttpURLConnection urlConnection = (HttpURLConnection)
                url.openConnection();
        String line;
        StringBuilder jsonString = new StringBuilder();

        urlConnection.setRequestProperty("Content-Type",
                "application/json; charset=UTF-8");
        urlConnection.setRequestMethod("POST");
        urlConnection.setDoInput(true);
        urlConnection.setInstanceFollowRedirects(false);
        urlConnection.connect();

        OutputStreamWriter outputStreamWriter = new
                OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
        outputStreamWriter.write(payload);
        outputStreamWriter.close();

        try {
            BufferedReader bufferedReader = new BufferedReader(new
                    InputStreamReader(urlConnection.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                jsonString.append(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        urlConnection.disconnect();
        return jsonString.toString();

    }

    public class PostRequest extends AsyncTask<String,Void, String>{

        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("LOADING..");
            progressDialog.setMessage("Please while we log you in..");
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... strings) {



            try {
                regno = "\"" + regno + "\"";
                password = "\"" + password + "\"";

                String response =
                        makePostRequest("http://projectvu.adgvit.com/login",
                                "{\"regno\" : " + regno + ", \"password\" : "
                                        + password + "}", getApplicationContext());
                return response;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
        }
    }
}



