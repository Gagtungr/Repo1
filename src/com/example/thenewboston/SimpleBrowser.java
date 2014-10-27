package com.example.thenewboston;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("SetJavaScriptEnabled") 
public class SimpleBrowser extends Activity implements OnClickListener {

	WebView wvBrw;
	EditText etUrl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.simplebrowser);
		
		wvBrw = (WebView) findViewById(R.id.wvBrowse);
		
		wvBrw.getSettings().setJavaScriptEnabled(true);
		wvBrw.setWebViewClient(new myWebClient());
		wvBrw.getSettings().setLoadWithOverviewMode(true);
		wvBrw.getSettings().setUseWideViewPort(true);
		
		wvBrw.loadUrl("http://www.gbg.bg");
		
		Button bGo = (Button) findViewById(R.id.bBrowse);
		Button bBack = (Button) findViewById(R.id.bBack);
		Button bFF = (Button) findViewById(R.id.bForward);
		Button bRefresh = (Button) findViewById(R.id.bRefresh);
		Button bClear = (Button) findViewById(R.id.bClearHist);
		etUrl = (EditText) findViewById(R.id.etURL);
		
		bGo.setOnClickListener(this);
		bBack.setOnClickListener(this);
		bFF.setOnClickListener(this);
		bRefresh.setOnClickListener(this);
		bClear.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()){
		case R.id.bBrowse:
			String sUrl = etUrl.getText().toString();
			wvBrw.loadUrl(sUrl);
			
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etUrl.getWindowToken(), 0);
			break;
		case R.id.bBack:
			if (wvBrw.canGoBack()) {
				wvBrw.goBack();
			}
			break;
		case R.id.bForward:
			if (wvBrw.canGoForward()) {
				wvBrw.goForward();
			}
			break;
		case R.id.bRefresh:
			wvBrw.reload();
			break;
		case R.id.bClearHist:
			wvBrw.clearHistory();
			break;
		}
		
	}
	
	class myWebClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			return super.shouldOverrideUrlLoading(view, url);
		}
		
	}

}
