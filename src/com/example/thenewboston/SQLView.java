package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sqlview);
		
		TextView tvSQLinfo = (TextView) findViewById(R.id.tvSQLInfo);
		
		HotOrNot info = new HotOrNot(this);
		info.openForWrite();
		String data = info.getData();
		info.closeDB();
		
		tvSQLinfo.setText(data);
		
	}
	

}
