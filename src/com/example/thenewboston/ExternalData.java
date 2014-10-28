package com.example.thenewboston;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener, OnClickListener {

	private TextView tvCanRead, tvCanWrite;
	private String state;
	private boolean canW, canR;
	Spinner spinner;
	String[] paths = {"Music", "Pics", "Downloads"};
	File path = null;
	File myFile = null;
	
	EditText etSaveAs;
	Button bConfirm, bSave;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.externaldata);
		
		tvCanRead = (TextView) findViewById(R.id.tvCanRead);
		tvCanWrite = (TextView) findViewById(R.id.tvCanWrite);
		spinner = (Spinner) findViewById(R.id.spinner1);
		etSaveAs = (EditText) findViewById(R.id.etSaveAs);
		bConfirm = (Button) findViewById(R.id.bConfirmSave);
		bSave = (Button) findViewById(R.id.bSaveFile);
		
		bConfirm.setOnClickListener(this);
		bSave.setOnClickListener(this);
		
		
		state = Environment.getExternalStorageState();
		
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			tvCanRead.setText("TRUE");
			tvCanWrite.setText("TRUE");
			canW = canR = true;
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			tvCanRead.setText("TRUE");
			tvCanWrite.setText("FALSE");
			canR = true;
			canW = false;
		} else {
			tvCanRead.setText("FALSE");
			tvCanWrite.setText("FALSE");
			canR = canW = false;
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExternalData.this, android.R.layout.simple_spinner_item, paths);
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(this);
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		int pos = spinner.getSelectedItemPosition();
		
		switch(pos){
		case 0:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			etSaveAs.setHint(path.toString());
			break;
		case 1:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			etSaveAs.setHint(path.toString());
			break;
		case 2:
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			etSaveAs.setHint(path.toString());
			break;
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSaveFile:
			String fname = etSaveAs.getText().toString();
			myFile = new File(path, fname);
			
			if (canR == canW == true) {
				try {
					path.mkdirs();
					
					InputStream is = getResources().openRawResource(R.drawable.green_ball);
					OutputStream os = new FileOutputStream(myFile);
					
					byte[] buff = new byte[is.available()];
					
					is.read(buff);
					os.write(buff);
					
					is.close();
					os.close();
					
					Toast t = Toast.makeText(ExternalData.this, "File saved!", Toast.LENGTH_LONG);
					t.show();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
			
			break;
		case R.id.bConfirmSave:
			bSave.setVisibility(View.VISIBLE);
			break;
		}
		
	}

}
