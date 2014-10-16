package com.example.thenewboston;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity  implements View.OnClickListener{
	
	ImageButton ibShoot;
	Button bSetWP;
	ImageView ivPic;
	Intent i;
	int camData = 0;
	Bitmap bmp;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.photo);
		init();
	}
	
	private void init() {
		ibShoot = (ImageButton) findViewById(R.id.ibTakePic);
		bSetWP = (Button) findViewById(R.id.bSetWP);
		ivPic = (ImageView) findViewById(R.id.ivReturnedPic);
		ibShoot.setOnClickListener(this);
		bSetWP.setOnClickListener(this);
		
		InputStream is = getResources().openRawResource(R.drawable.ic_launcher);
		bmp = BitmapFactory.decodeStream(is);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.ibTakePic:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, camData);
			break;
		case R.id.bSetWP:
			
			
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			bmp = (Bitmap) extras.get("data");
			ivPic.setImageBitmap(bmp);
		}
	}

}
