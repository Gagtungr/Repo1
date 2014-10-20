package com.example.thenewboston;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class MyBringBAck extends View {

	Bitmap gBall;
	
	public MyBringBAck(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.green_ball);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		canvas.drawColor(Color.WHITE);
		
		canvas.drawBitmap(gBall, canvas.getWidth()/2 , canvas.getHeight()/2, null);
	}

}
