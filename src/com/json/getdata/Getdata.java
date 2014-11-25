package com.json.getdata;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.emildesign.jsonparsingapp.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Getdata extends Activity{

	String url = "http://api.androidhive.info/contacts/" ;
	TextView abc;
	JSONObject json;
	private List<Phone> List = new ArrayList<Phone>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        abc = (TextView) findViewById(R.id.txt);

ParsingJson json= new ParsingJson();
json.execute();

	}

class  ParsingJson extends AsyncTask<Contact, Void, String>  {

	@Override
	protected String doInBackground(Contact... params) {
		// TODO Auto-generated method stub
		InputStream source = retrieveStream(url);
		
		Gson gson = new Gson();
		Reader reader = new InputStreamReader(source);
		
		Contact response = gson.fromJson(reader, Contact.class);
		String a = null;
//		
		List<Element> results = response.contacts;
		Log.d("acbc", results.toString());
		
		for (Element result : results) {
			a = a+ result.toString() +"\n" ;
			
		}
				
		return a;
	}
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		// TODO Auto-generated method 
//		Toast.makeText(getApplicationContext(), "1 "+result, Toast.LENGTH_LONG).show();
		abc.setText(result);
	}

	
	
}

	private InputStream retrieveStream(String url) {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet(url);

		try {
			HttpResponse getResponse = client.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();

			if (statusCode != HttpStatus.SC_OK) { 
				Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);
				return null;
			}

			HttpEntity getResponseEntity = getResponse.getEntity();
			return getResponseEntity.getContent();
		} catch (IOException e) {
			getRequest.abort();
			Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
		}

		return null;
	}


	
}
