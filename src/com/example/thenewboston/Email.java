package com.example.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {

	EditText personsEmail, intro, personsName, stupidThings, hatefulAction, outro;
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	Button sendMail;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.email);
		InitVars();
		sendMail.setOnClickListener(this);
		
	}
	
	private void InitVars() {
		personsEmail = (EditText) findViewById(R.id.etEmAddr);
		intro = (EditText) findViewById(R.id.etIntro);
		personsName = (EditText) findViewById(R.id.etNames);
		stupidThings = (EditText) findViewById(R.id.etStupThigs);
		hatefulAction = (EditText) findViewById(R.id.etHate);
		outro = (EditText) findViewById(R.id.etOutro);
		sendMail = (Button) findViewById(R.id.bSendMail);
		
	}

	private void CovertETIntoStrings() {
		emailAdd = personsEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personsName.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();
		
	}



	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		CovertETIntoStrings();
		
		String emailAddrss[] = {emailAdd};
		String message = "Well Hello " + name + " Ijust wanted to say " + beginning + ". Not only but i hate when you " +
				stupidAction + ", that just raly makes me crazy. I just want to make " + hatefulAct + "Welp, thats just all " +
				out + "If you get bored, goto .... " + '\n' + "Grrrrr";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddrss);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hate mail!");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		startActivity(emailIntent);
		
	}
	

}
