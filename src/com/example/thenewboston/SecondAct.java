package com.example.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class SecondAct extends Activity {

	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.second_act);

		ourSong = MediaPlayer.create(SecondAct.this, R.raw.some_tune);

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());

		boolean isMusicOn = sp.getBoolean("chkbox", true);

		if (isMusicOn) {
			ourSong.start();
		}

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStartingPoint = new Intent(
							"com.example.thenewboston.MENU");
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
