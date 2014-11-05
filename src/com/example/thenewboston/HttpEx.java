package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HttpEx extends Activity {
	
	TextView tvHttpStuff;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.httpex);
		
		tvHttpStuff = (TextView) findViewById(R.id.tvHttp);
		
		GetMethodEx test = new GetMethodEx();
		try {
			tvHttpStuff.setText(test.getInternetData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
