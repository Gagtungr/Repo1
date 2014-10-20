package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;

public class GFX extends Activity {

	MyBringBAck ourView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ourView = new MyBringBAck(this);
		setContentView(ourView);
	}
	
	

}
