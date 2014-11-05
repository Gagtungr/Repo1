package com.example.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Accelerate extends Activity implements SensorEventListener {
	
	
	private Sensor m_AccSensor;
	private SensorManager sm;
	
	float x, y, sensX, sensY;
	Bitmap gball;
	MySurface m_surf;

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		m_surf = new MySurface(this);
		m_surf.resume();
		setContentView(m_surf);
		
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() > 0) {
			m_AccSensor = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, m_AccSensor, SensorManager.SENSOR_DELAY_NORMAL);
			
		}
		
		gball = BitmapFactory.decodeResource(getResources(), R.drawable.green_ball);
		x = y = sensX = sensY = 0;
		
	}

	@Override
	protected void onPause() {
		sm.unregisterListener(this);

		super.onPause();
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sensX = se.values[0];
		sensY = se.values[1];
	}

	public class MySurface extends SurfaceView implements Runnable {

		SurfaceHolder myHolder;
		Thread myThread = null;
		boolean isRunning = false;

		public MySurface(Context context) {
			super(context);

			myHolder = getHolder();
			myThread = new Thread(this);
			myThread.start();
		}

		public void pause() {
			isRunning = false;

			while (true) {
				try {
					myThread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

			myThread = null;
		}

		public void resume() {
			isRunning = true;

			myThread = new Thread(this);
			myThread.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			while (isRunning) {
				if (!myHolder.getSurface().isValid())
					continue;

				Canvas canv = myHolder.lockCanvas();
				canv.drawRGB(10, 10, 120);
				
				float centerX = canv.getWidth() / 2 ;
				float centerY = canv.getHeight() / 2;

				canv.drawBitmap(gball, centerX + sensX*20, centerY + sensY*20, null);
				
				myHolder.unlockCanvasAndPost(canv);

			}

		}

	}

}
