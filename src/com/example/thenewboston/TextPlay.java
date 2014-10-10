package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity{

	Button bChk;
	ToggleButton tbPass;
	EditText etInput;
	TextView tvDisp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.text);
		
		bChk = (Button) findViewById(R.id.bResults);
		tbPass = (ToggleButton) findViewById(R.id.tbPassword);
		etInput = (EditText) findViewById(R.id.etCommands);
		tvDisp = (TextView) findViewById(R.id.tvResults);
		
		bChk.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String check = etInput.getText().toString();
				
				if (check.contentEquals("left")) {
					tvDisp.setGravity(Gravity.LEFT);
				} else if (check.contentEquals("center")) {
					tvDisp.setGravity(Gravity.CENTER);
				} else if (check.contentEquals("right")) {
					tvDisp.setGravity(Gravity.RIGHT);
				} else if (check.contentEquals("blue")) {
					
				}
				
				
			}
		});
		
	}
	
	public void tbPassOnCLick (View v) {
		
		if (tbPass.isChecked()) {
			etInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		} else {
			etInput.setInputType(InputType.TYPE_CLASS_TEXT);
		}
		
	}
	
	
	

}
