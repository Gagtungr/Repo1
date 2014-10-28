package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SQLLiteEx extends Activity implements OnClickListener {

	Button bSQLUpdate, bSQLView;
	EditText etName, etHotness;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sqlliteex);
		
		bSQLUpdate = (Button) findViewById(R.id.bSQLUpdate);
		bSQLView = (Button) findViewById(R.id.bSQLView);
		etName = (EditText) findViewById(R.id.etSQLName);
		etHotness = (EditText) findViewById(R.id.etSQLHotness);
		
		bSQLUpdate.setOnClickListener(this);
		bSQLView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSQLUpdate:
			String name = etName.getText().toString();
			String hotness = etHotness.getText().toString();
			
			HotOrNot entry = new HotOrNot(this);
			entry.openForWrite();
			
			
			entry.closeDB();
			break;
		case R.id.bSQLView:
			break;
		}
		
	}

}
