package com.example.mytabhostdemo;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MyTabHostDemo extends TabActivity {

	private TabHost myTabHost;
	private int[]layRes = {R.id.tab_edit,R.id.tab_clock,R.id.sex};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.myTabHost = super.getTabHost();
		LayoutInflater.from(this).inflate(R.layout.tab,this.myTabHost.getTabContentView(),true);
		for(int i=0; i<this.layRes.length; i++){
			TabSpec myTab = myTabHost.newTabSpec("tab"+i);
			myTab.setIndicator("±êÇ©-"+i);
			myTab.setContent(this.layRes[i]);
			this.myTabHost.addTab(myTab);
		}
	}

}
