package com.example.set_activity_title;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityEventMain extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_event_main);
		super.setTitle("窗口标题");
		Button setActivityTitleBtn = (Button)super.findViewById(R.id.setActivityTitle);
		setActivityTitleBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_event_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		setTitle("新窗口标题");
		setTitleColor(12345);
	}

	//	窗口完全显示后开始口调用
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		Log.d("ActivityEventMain", "onPostCreate");
		super.onPostCreate(savedInstanceState);
	}
	
	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		super.onTitleChanged(title, color);
		Log.d("ActivityEventMain", "onTitleChanged_title:"+title);
		Log.d("ActivityEventMain", "onTitlechanged_color:"+color);
	}
	
	
}
