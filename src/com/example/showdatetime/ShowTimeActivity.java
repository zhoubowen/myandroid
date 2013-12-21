package com.example.showdatetime;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.showtime.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShowTimeActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//装载布局文件
		setContentView(R.layout.activity_show_time);
		Button btnShowDate = (Button)super.findViewById(R.id.btnShowDate);
		Button btnShowTime = (Button)super.findViewById(R.id.btnShowTime);
		btnShowDate.setOnClickListener(this);
		btnShowTime.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_time, menu);
		return true;
	}
	
	/**
	 * 通用对话框
	 * @param title
	 * @param msg
	 */
	private void showDialog(String title,String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setTitle(title);
		builder.setMessage(msg);
		builder.setPositiveButton("确定", null);
		builder.create().show();
	}
	
	/**
	 * 共用一个单击事件，根据ID区分
	 */
	@Override
	public void onClick(View v){
		switch (v.getId()) {
			case R.id.btnShowDate:
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				showDialog("当前日期",sdf.format(new Date()));
				break;
			}
			case R.id.btnShowTime:
			{
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				showDialog("当前时间",sdf.format(new Date()));
				break;
			}
			default:
				break;
		}
	}

}
