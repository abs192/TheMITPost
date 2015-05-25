package com.themitpost;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import android.content.Context;

public class ApplicationLoader extends Application {

	public static Context applicationContext = null;
	public static RequestQueue requestQueue = null;

	@Override
	public void onCreate() {
		super.onCreate();

		ApplicationLoader.applicationContext = getApplicationContext();
		requestQueue = Volley.newRequestQueue(applicationContext);

	}

}
