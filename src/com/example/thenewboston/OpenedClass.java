package com.example.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	TextView question, test;
	Button retData;
	RadioGroup rg;
	String gotBread, sentData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.sender);
		init();

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		String name = sp.getString("name", "My name is ...");
		String values = sp.getString("list", "4");

		if (values.contains("1")) {
			question.setText(name);
		}
	}

	private void init() {
		// TODO Auto-generated method stub

		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		retData = (Button) findViewById(R.id.bReturn);
		retData.setOnClickListener(this);

		rg = (RadioGroup) findViewById(R.id.rgAnswers);
		rg.setOnCheckedChangeListener(this);

		/*
		 * Bundle gotBasket = getIntent().getExtras(); gotBread =
		 * gotBasket.getString("key"); question.setText(gotBread);
		 */

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle bagpack = new Bundle();
		bagpack.putString("answer", sentData);
		person.putExtras(bagpack);
		setResult(RESULT_OK, person);
		finish();

	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.rGay:
			sentData = "Sure!";
			break;
		case R.id.rLesb:
			sentData = "Hopefuly!";
			break;
		case R.id.rBoth:
			sentData = "Nice!";
			break;
		}

		test.setText(sentData);
	}

}
