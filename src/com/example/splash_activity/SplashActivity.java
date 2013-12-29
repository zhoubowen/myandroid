package com.example.splash_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class SplashActivity extends Activity {
	private final int SPLASH_DISPLAY_LENGTH = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
//				Intent intent = new Intent(SplashActivity.this,MainActivity.class);
				Intent intent = new Intent();
				intent.setClass(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(intent);
				SplashActivity.this.finish();
			}
		},this.SPLASH_DISPLAY_LENGTH);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
