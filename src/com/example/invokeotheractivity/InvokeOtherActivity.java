package com.example.invokeotheractivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class InvokeOtherActivity extends Activity {
	private Context mContext;
	private Class mClass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_invoke_other);
		try {
			//指向Web_browser应用的context
			mContext = createPackageContext("com.example.web_browser", CONTEXT_INCLUDE_CODE | 
					CONTEXT_IGNORE_SECURITY);
			mClass = mContext.getClassLoader().loadClass("com.example.web_browser.WebBrowserActivity");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.invoke_other, menu);
		return true;
	}

	public void onClick_Action(View view){
		Intent webIntent = new Intent(Intent.ACTION_VIEW);
		Uri uri = Uri.parse("http://www.baidu.com");
		webIntent.setData(uri);
		startActivity(webIntent);
	}
	
	public void onClick_SetClassName(View view){
		Intent intent = new Intent();
		intent.setClassName("com.example.web_browser", "com.example.web_browser.WebBrowserActivity");
		intent.setData(Uri.parse("http://www.google.com.hk"));
		startActivity(intent);
	}
	
	public void onClick_SetClassName_Context(View view){
		if(mContext == null || mClass == null)return;
		Intent intent = new Intent();
		intent.setClassName(mContext, "com.example.web_browser.WebBrowserActivity");
		intent.setData(Uri.parse("http://www.baidu.com"));
		this.startActivity(intent);
	}
	
	public void onClick__SetClass(View view){
		if(mContext == null || mClass == null)return;
		Intent intent = new Intent();
		intent.setClass(mContext, mClass);
		intent.setData(Uri.parse("http://www.google.com.hk"));
		startActivity(intent);
	}
	
	public void onClick_SetComponentName(View view){
		if(mContext == null || mClass == null)return;
		Intent intent = new Intent();
		ComponentName cn = new ComponentName(mContext,mClass);
		intent.setComponent(cn);
		intent.setData(Uri.parse("http://www.baidu.com"));
		startActivity(intent);
	}
	
	public void onClick_ShowCalculator(View view){
		Intent intent = new Intent();
		intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
		startActivity(intent);
	}
}
