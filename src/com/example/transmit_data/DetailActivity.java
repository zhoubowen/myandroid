package com.example.transmit_data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.transmit.pojo.User;


public class DetailActivity extends Activity {
	public static String name;
	public static int number;
	public static User user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.detail);
		
		//Intent传值
		Intent intent = super.getIntent();
		String intent_string = intent.getStringExtra("intent_string");
		int intentInteger = intent.getExtras().getInt("intent_integer");
		User user = (User)intent.getExtras().get("intent_object");
		TextView textView = (TextView)super.findViewById(R.id.detailTxt);
		StringBuffer sb = new StringBuffer();
		sb.append("intent_string:").append(intent_string).append("\n");
		sb.append("intent_integer:").append(intentInteger).append("\n");
		sb.append("user_name:").append(user.getName()).append("\n");
		sb.append("user_age:").append(user.getAge());
		textView.setText(sb.toString());
		
		//静态变量传值 （官方不推荐使用，数据大影响性能）
//		TextView textView = (TextView)super.findViewById(R.id.detailTxt);
//		StringBuffer sb = new StringBuffer();
//		sb.append("intent_string:").append(name).append("\n");
//		sb.append("intent_integer:").append(number).append("\n");
//		sb.append("user_name:").append(user.getName()).append("\n");
//		sb.append("user_age:").append(user.getAge());
//		textView.setText(sb.toString());
		
		//剪切板传值 （不推荐使用，可能会影响其它应用，因为其它应用可能用到剪切板）
//		TextView textView = (TextView)super.findViewById(R.id.detailTxt);
//		ClipboardManager clipboardManager = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
//		String base64Str = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
//		byte[]buffer = Base64.decode(base64Str, Base64.DEFAULT);
//		ByteArrayInputStream in = new ByteArrayInputStream(buffer);
//		try {
//			ObjectInputStream objIn = new ObjectInputStream(in);
//			User user = (User)objIn.readObject();
//			StringBuffer sb = new StringBuffer();
//			sb.append("name:").append(user.getName()).append("\n");
//			sb.append("age:").append(user.getAge());
//			textView.setText(sb.toString());
//		} catch (Exception e) {
//		}
		
		//全局变量传值（不可以序列号的对象可以采用静态变量或全局变量，建议才全局变量）
//		TextView textView = (TextView)super.findViewById(R.id.detailTxt);
//		MyApp myApp = (MyApp)super.getApplicationContext();
//		StringBuffer stringBuffer = new StringBuffer();
//		stringBuffer.append("ID:").append(myApp.id).append("\n");
//		stringBuffer.append("Name:").append(myApp.user.getName()).append("\n");
//		stringBuffer.append("Age:").append(myApp.user.getAge());
//		textView.setText(stringBuffer.toString());

	}

}
