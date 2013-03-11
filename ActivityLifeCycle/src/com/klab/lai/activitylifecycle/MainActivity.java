package com.klab.lai.activitylifecycle;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.klab.lai.mysecondapp.R;

public class MainActivity extends Activity {
	private static final String MY_TAG = "Lance1";
	private TextView mTextView;
	private int mLevel;
	private int mScore;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(savedInstanceState != null){
			mLevel = savedInstanceState.getInt(STATE_LEVEL);
			mScore = savedInstanceState.getInt(STATE_SCORE);
		}else{
			mLevel = 0;
			mScore = 30;
		}

		setContentView(R.layout.activity_main);
		Log.i(MY_TAG, "on create");
		mTextView = (TextView) findViewById(R.id.text_message);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setHomeButtonEnabled(false);
		}
	}
	static final String STATE_SCORE = "playerScore";
	static final String STATE_LEVEL = "playerLevel";
	@Override
	protected void onStart() {
		super.onStart();
		Log.i(MY_TAG, "on start");
	}
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		mLevel = savedInstanceState.getInt(STATE_LEVEL);
		mScore = savedInstanceState.getInt(STATE_SCORE);
		Log.i(MY_TAG, "on restore instance state");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.i(MY_TAG, "on stop");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(MY_TAG, "on restart");
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.i(MY_TAG, "on save instance state");
		mLevel = mLevel + 1;
		mScore = mScore + 10;
		outState.putInt(STATE_LEVEL, mLevel);
		outState.putInt(STATE_SCORE, mScore);
		super.onSaveInstanceState(outState);
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.i(MY_TAG, "on resume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(MY_TAG, "on pause");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
