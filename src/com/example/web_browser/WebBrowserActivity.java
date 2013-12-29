package com.example.web_browser;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class WebBrowserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_browser);
		setContentView(R.layout.activity_web_browser);
		WebView webView = (WebView)super.findViewById(R.id.webview);
		Uri uri = getIntent().getData();
		if(uri != null){
			webView.loadUrl(uri.toString());
			setTitle(uri.toString());
		}else {
			webView.loadUrl("http://www.cnblogs.com/wendoudou");
			setTitle("ÎÄ¶¹¶¹");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_browser, menu);
		return true;
	}

}
