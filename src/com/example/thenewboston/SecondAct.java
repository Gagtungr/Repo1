package com.example.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SecondAct extends Activity {

	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.second_act);
		
		ourSong = MediaPlayer.create(SecondAct.this, R.raw.some_tune);
		ourSong.start();
		
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent("com.example.thenewboston.MENU");
					startActivity(openStartingPoint);
					
				}
			}
		};
		
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		ourSong.release();
		
		finish();
	}
	
	
	

}
