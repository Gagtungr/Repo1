package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	TextView question, test;
	Button retData;
	RadioGroup rg;
	String gotBread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sender);
		init();
		
		Bundle gotBasket = getIntent().getExtras();
		gotBread = gotBasket.getString("key");
		question.setText(gotBread);
	}

	private void init() {
		// TODO Auto-generated method stub
		
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		retData = (Button) findViewById(R.id.bReturn);
		retData.setOnClickListener(this);
		
		rg = (RadioGroup) findViewById(R.id.rgAnswers);
		rg.setOnCheckedChangeListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1) {
		case R.id.rGay:
			break;
		case R.id.rLesb:
			break;
		case R.id.rBoth:
			break;
		}
	}

}
