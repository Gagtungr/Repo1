package com.example.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {

	Button bStart, bStop, bAddTab;
	TabHost th;
	TextView tvResults;
	long start = 0, stop = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.tabs);
		
		bStart = (Button) findViewById(R.id.bStartW);
		bStop = (Button) findViewById(R.id.bStopW);
		bAddTab = (Button) findViewById(R.id.bAddTab);
		tvResults = (TextView) findViewById(R.id.tvShowResults);
		
		bAddTab.setOnClickListener(this);
		bStart.setOnClickListener(this);
		bStop.setOnClickListener(this);
		
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Stop Watch");
		th.addTab(specs);
		
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab 2");
		th.addTab(specs);
		
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Add a Tab");
		th.addTab(specs);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bStartW:
			start = System.currentTimeMillis();
			break;
		case R.id.bStopW:
			stop = System.currentTimeMillis();
			
			if (start != 0) {
				long res = stop - start;
				int mils = (int) res;
				int secs = (int) res / 1000;
				int mins = secs / 60;
				tvResults.setText(String.format("%d:%02d:%02d", mins, secs, mils));
				
			}
				
			break;
		case R.id.bAddTab:
			TabSpec newspec = th.newTabSpec("newtag");
			newspec.setContent(new TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					TextView tvx = new TextView(Tabs.this);
					tvx.setText("You just added a new Tab!");
					return tvx;
				}
			});
			newspec.setIndicator("New Tab");
			th.addTab(newspec);
			
			break;
		}
		
	}
	

}
