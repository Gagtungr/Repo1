package com.example.thenewboston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyBringBAck extends View {

	Bitmap gBall;
	float changeY;
	
	public MyBringBAck(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.green_ball);
		changeY = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		canvas.drawColor(Color.WHITE);
		
		canvas.drawBitmap(gBall, canvas.getWidth()/2 , changeY, null);
		
		if (changeY < canvas.getHeight()) {
			changeY += 10;
		} else {
			changeY = 0;
		}
		
		Rect midRect = new Rect();
		Paint ourB = new Paint();
		
		midRect.set(0, 400, canvas.getWidth(), 550);
		ourB.setColor(Color.BLUE);
		
		canvas.drawRect(midRect, ourB);
		invalidate();
	}

}
