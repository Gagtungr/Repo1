package com.example.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener {
	
	MySurface SurfaceView;
	float x, y, sX, sY, fX, fY, dx, dy, anix, aniy, scaledx, scaledy; 
	Bitmap bmp, plus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		SurfaceView = new MySurface(this);
		SurfaceView.setOnTouchListener(this);
		x = sX = fX = 0;
		y = sY = fY = 0;
		dx = dy = anix = aniy = scaledx = scaledy = 0;
		
		bmp = BitmapFactory.decodeResource(getResources(), R.drawable.green_ball);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.normal_state);
		
		setContentView(SurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		SurfaceView.pause();
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		SurfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x = event.getX();
		y = event.getY();
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			sX = event.getX();
			sY = event.getY();
			dx = dy = anix = aniy = scaledx = scaledy = 0;
			break;
		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			
			dx = fX - sX;
			dy = fY - sY;
			scaledx = dx / 30;
			scaledy = dy / 30;
			x = y = 0;
			break;
		}

		return true;
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
				if(!myHolder.getSurface().isValid())
					continue;
				
				Canvas canv = myHolder.lockCanvas();
				canv.drawRGB(10, 10, 120);
				
				if (x != 0 && y != 0) {
					canv.drawBitmap(bmp, x - bmp.getWidth() / 2, y - bmp.getHeight() / 2, null);
				}

				if (sX != 0 && fY != 0) {
					canv.drawBitmap(plus, sX - plus.getWidth() / 2, sY - plus.getHeight() / 2, null);
				}

				if (fX != 0 && fY != 0) {
					canv.drawBitmap(bmp, fX - (bmp.getWidth() / 2) + anix, fY - (bmp.getHeight() / 2) + aniy, null);
					canv.drawBitmap(plus, fX - plus.getWidth() / 2, fY - plus.getHeight() / 2, null);
				}
				
				anix = anix + scaledx;
				aniy = aniy + scaledy;
				
				myHolder.unlockCanvasAndPost(canv);
				
			}
			
		}

	}

	
}
