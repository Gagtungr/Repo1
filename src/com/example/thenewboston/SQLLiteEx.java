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
import android.widget.Toast;

public class SQLLiteEx extends Activity implements OnClickListener {

	Button bSQLUpdate, bSQLView, bEdit, bGetInfo, bDelete;
	EditText etName, etHotness, etSQLRowId;

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
		
		etSQLRowId = (EditText) findViewById(R.id.etSQLRowInfo);
		bEdit = (Button) findViewById(R.id.bSQLEdit);
		bGetInfo = (Button) findViewById(R.id.bSQLGetInfo);
		bDelete = (Button) findViewById(R.id.bSQLDelete);
		
		bEdit.setOnClickListener(this);
		bGetInfo.setOnClickListener(this);
		bDelete.setOnClickListener(this);
		
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
				String errmsg = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Something gone wrong!");
				TextView tv = new TextView(this);
				tv.setText(errmsg);
				d.setContentView(tv);
				d.show();
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
		case R.id.bSQLGetInfo:
			Long rwid  = Long.parseLong(etSQLRowId.getText().toString());
			HotOrNot hon = new HotOrNot(this);
			hon.openForWrite();
			String name = hon.getNameById(rwid);
			String hotness = hon.getHotnessById(rwid);
			hon.closeDB();
			
			etName.setText(name);
			etHotness.setText(hotness);
			
			break;
		case R.id.bSQLEdit:
			name = etName.getText().toString();
			hotness = etHotness.getText().toString();
			rwid  = Long.parseLong(etSQLRowId.getText().toString());
			
			HotOrNot honUpd = new HotOrNot(this);
			honUpd.openForWrite();
			honUpd.updEntry(rwid, name, hotness);
			honUpd.closeDB();
			break;
		case R.id.bSQLDelete:
			rwid  = Long.parseLong(etSQLRowId.getText().toString());
			HotOrNot entrDel = new HotOrNot(this);
			entrDel.openForWrite();
			entrDel.DeleteEntr(rwid);
			entrDel.closeDB();
			
			Toast tt = Toast.makeText(this, "Entry deleted!", Toast.LENGTH_LONG);
			tt.show();
			
			break;
		}

	}
}
