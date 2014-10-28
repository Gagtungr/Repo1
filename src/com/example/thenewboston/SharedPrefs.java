package com.example.thenewboston;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener {

	EditText etSharedData;
	TextView tvDataRes;
	public static String filename = "MySharedPrefs";
	SharedPreferences someData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sharedprefs);
		setupVars();
		
		someData = getSharedPreferences(filename, MODE_PRIVATE);
	}

	private void setupVars() {
		
		Button bSave = (Button) findViewById(R.id.bSave);
		Button bLoad = (Button) findViewById(R.id.bLoad);
		etSharedData = (EditText) findViewById(R.id.etSharedPrefs);
		tvDataRes = (TextView) findViewById(R.id.tvStatus);
		
		bSave.setOnClickListener(this);
		bLoad.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSave:
			String strdata = etSharedData.getText().toString();
			SharedPreferences.Editor editor = someData.edit();
			editor.putString("key1", strdata);
			editor.commit();
			break;
		case R.id.bLoad:
			String res = someData.getString("key1", "def");
			tvDataRes.setText(res);
			break;
		}
		
	}

}
