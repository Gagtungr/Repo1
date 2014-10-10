package com.example.thenewboston;




import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class StartPoint extends Activity {
	
	int counter;
	TextView tvDisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_point);
        
        counter = 0;
        tvDisp = (TextView) findViewById(R.id.tvDisp);
        
        tvDisp.setText("Your counter is " + counter);
    }



    
    public void addOne (View v) {
    	counter += 1;
    	tvDisp.setText("Your counter is " + counter);
    }
    
    public void subOne (View v) {
    	counter -= 1;
    	tvDisp.setText("Your counter is " + counter);
    }
    
    
}
