package com.example.thenewboston;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

			boolean diditworked = true;
			try {
				String name = etName.getText().toString();
				String hotness = etHotness.getText().toString();

				HotOrNot entry = new HotOrNot(this);
				entry.openForWrite();
				entry.createEntry(name, hotness);
				entry.closeDB();
			} catch (Exception e) {
				diditworked = false;
			} finally {
				if (diditworked) {
					Dialog d = new Dialog(this);
					d.setTitle("Heck yea!");
					TextView tv = new TextView(this);
					tv.setText("Success!");
					d.setContentView(tv);
					d.show();
				}
			}
			break;
		case R.id.bSQLView:
			Intent i = new Intent("com.example.thenewboston.SQLVIEW");
			startActivity(i);
			break;
		}

	}
}
