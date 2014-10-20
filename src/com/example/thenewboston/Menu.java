package com.example.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "StartPoint", "TextPlay", "Email", "Camera", "Data", "GFX" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		String pos = classes[position];

		try {
			Class ourClass = Class.forName("com.example.thenewboston." + pos);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.example.thenewboston.ABOUT");
			startActivity(i);
			break;
		case R.id.prefs:
			Intent p = new Intent("com.example.thenewboston.PREFS");
			startActivity(p);
			break;
		case R.id.Exit:
			finish();
			break;
		}

		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);

		return true;

	}

}
