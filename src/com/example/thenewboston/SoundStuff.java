package com.example.thenewboston;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SoundStuff extends Activity implements OnClickListener {

	SoundPool sp;
	int jetCrash = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		View v = new View(this);
		v.setOnClickListener(this);
		
		setContentView(v);
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		jetCrash = sp.load(this, R.raw.jet_crash, 1);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if (jetCrash != 0)
			sp.play(jetCrash, 1, 1, 0, 0, 1);
		
	}
	

}
