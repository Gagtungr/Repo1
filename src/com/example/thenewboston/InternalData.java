package com.example.thenewboston;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	EditText etSharedData;
	TextView tvDataRes;
	FileOutputStream fos;
	FileInputStream fis;
	static String FILENAME = "InternalFile";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.sharedprefs);
		setupVars();
	}

	private void setupVars() {
		
		Button bSave = (Button) findViewById(R.id.bSave);
		Button bLoad = (Button) findViewById(R.id.bLoad);
		etSharedData = (EditText) findViewById(R.id.etSharedPrefs);
		tvDataRes = (TextView) findViewById(R.id.tvStatus);
		
		bSave.setOnClickListener(this);
		bLoad.setOnClickListener(this);
		
		try {
			fos = openFileOutput(FILENAME, MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bSave:
			String data = etSharedData.getText().toString();

			//Saving data via File
/*			File f = new File(FILENAME);
			try {
				fos = new FileOutputStream(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
*/		
			try {
				fos = openFileOutput(FILENAME, MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			break;
		case R.id.bLoad:
			new loadSomeStuff().execute(FILENAME);
			
			break;
		}
		
	}
	
	public class loadSomeStuff extends AsyncTask<String, Integer, String> {
		
		ProgressDialog progdiag;

		@Override
		protected String doInBackground(String... params) {
			String collected = null;
			
			for(int i = 0; i < 100; i++) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				publishProgress(1);
			}
			
			try {
				fis = openFileInput(FILENAME);
				byte[] buff = new byte[fis.available()];
				while (fis.read(buff) != -1) {
					collected = new String(buff);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					return collected;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			tvDataRes.setText(result);
			progdiag.dismiss();
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			
			progdiag.incrementProgressBy(values[0]);
		}
		
		@Override
		protected void onPreExecute() {
			progdiag = new ProgressDialog(InternalData.this);
			progdiag.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progdiag.setMax(100);
			progdiag.show();
			
		}

	}
	
}
