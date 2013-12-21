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
		//װ�ز����ļ�
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
	 * ͨ�öԻ���
	 * @param title
	 * @param msg
	 */
	private void showDialog(String title,String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setTitle(title);
		builder.setMessage(msg);
		builder.setPositiveButton("ȷ��", null);
		builder.create().show();
	}
	
	/**
	 * ����һ�������¼�������ID����
	 */
	@Override
	public void onClick(View v){
		switch (v.getId()) {
			case R.id.btnShowDate:
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				showDialog("��ǰ����",sdf.format(new Date()));
				break;
			}
			case R.id.btnShowTime:
			{
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				showDialog("��ǰʱ��",sdf.format(new Date()));
				break;
			}
			default:
				break;
		}
	}

}
