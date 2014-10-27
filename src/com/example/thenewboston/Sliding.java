package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;


public class Sliding extends Activity implements OnClickListener, OnCheckedChangeListener, OnDrawerOpenListener {

	SlidingDrawer sd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sliding);
		
		Button handle1 = (Button) findViewById(R.id.bHandle1);
		Button handle2 = (Button) findViewById(R.id.bHandle2);
		Button handle3 = (Button) findViewById(R.id.bHandle3);
		Button handle4 = (Button) findViewById(R.id.bHandle4);
		CheckBox cbsl = (CheckBox) findViewById(R.id.cbSlidable);
		sd = (SlidingDrawer) findViewById(R.id.slidingD);

		sd.setOnDrawerOpenListener(this);
		cbsl.setOnCheckedChangeListener(this);
		handle1.setOnClickListener(this);
		handle2.setOnClickListener(this);
		handle3.setOnClickListener(this);
		handle4.setOnClickListener(this);
		
		
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
		if (isChecked){
			sd.lock();
		}else {
			sd.unlock();
		}
		
	}

	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
			case R.id.bHandle1:
				sd.open();
				break;
			case R.id.bHandle2:
				break;
			case R.id.bHandle3:
				sd.toggle();
				break;
			case R.id.bHandle4:
				sd.close();
				break;
		}
		
		
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		
	}

}
