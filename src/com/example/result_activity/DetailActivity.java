package com.example.result_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends Activity {
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
	}
	
	public void ok_result(View v){
		textView = (TextView)super.findViewById(R.id.titleTxt);
		Intent intent = new Intent();
		intent.putExtra("vlaue", textView.getText());
		setResult(2,intent);
		finish();
	}
}
