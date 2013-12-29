package com.example.transmit_data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.transmit.pojo.User;

public class TransmitDataActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.btn_list);
		
		Button intentDataBtn = (Button)findViewById(R.id.intentDataBtn);
		Button staticBtn = (Button)findViewById(R.id.staticDataBtn);
		Button clipDataBtn = (Button)findViewById(R.id.clipDataBtn);
		Button appDataBtn = (Button)findViewById(R.id.appDataBtn);
		intentDataBtn.setOnClickListener(this);
		staticBtn.setOnClickListener(this);
		clipDataBtn.setOnClickListener(this);
		appDataBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.transmit_data, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this,DetailActivity.class);
		switch (v.getId()) {
		case R.id.intentDataBtn://intent传值
			User user = new User(24, "张三");
			intent.putExtra("intent_string", "拖拉机");
			intent.putExtra("intent_integer", 10086);
			intent.putExtra("intent_object", user);
			break;
		case R.id.staticDataBtn://静态数据传值
			DetailActivity.name = "摩托车";
			DetailActivity.number = 1024;
			DetailActivity.user = new User(30, "李四");
			break;
		case R.id.clipDataBtn://剪贴板传值
			ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
			User pojo = new User(22,"流川枫");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			String base64Str = "";
			try {
				ObjectOutputStream objOut = new ObjectOutputStream(out);
				objOut.writeObject(pojo);
				base64Str = Base64.encodeToString(out.toByteArray(), Base64.DEFAULT);
			} catch (IOException e) {
			}
			ClipData clipData = ClipData.newPlainText("user", base64Str);
			clipboardManager.setPrimaryClip(clipData);
			break;
		case R.id.appDataBtn:
			MyApp myApp = (MyApp)getApplicationContext();
			myApp.id = 1024;
			myApp.user.setAge(24);
			myApp.user.setName("zbw");
			break;
		default:
			break;
		}
		startActivity(intent);
	}

}
