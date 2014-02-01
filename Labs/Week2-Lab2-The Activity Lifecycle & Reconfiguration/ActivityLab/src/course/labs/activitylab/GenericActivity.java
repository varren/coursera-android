package course.labs.activitylab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GenericActivity extends Activity {
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";
	
	private static final String TAG = "";
	
	private static final String CREATE_LOG_TEXT   = "Entered the onCreate() method";
	private static final String START_LOG_TEXT    = "Entered the onStart() method";
	private static final String RESUME_LOG_TEXT   = "Entered the onResume() method";
	private static final String PAUSE_LOG_TEXT    = "Entered the onPause() method";
	private static final String STOP_LOG_TEXT     = "Entered the onStop() method";
	private static final String DESTROY_LOG_TEXT  = "Entered the onDestroy() method";
	private static final String RESTART_LOG_TEXT  = "Entered the onRestart() method";
	private int mCreate = 0;
	private int mStart = 0;
	private int mResume = 0;
	private int mRestart = 0;
	

	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	private TextView mTvCreate;
	private TextView mTvStart;
	private TextView mTvResume;
	private TextView mTvRestart;
	
	protected Context getCurrentContext(){
		return this.getApplicationContext();
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(currentActivityID());
		
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

			mTvCreate = (TextView) findViewById(R.id.create);
			mTvStart = (TextView) findViewById(R.id.start);
			mTvResume = (TextView) findViewById(R.id.resume);
			mTvRestart = (TextView) findViewById(R.id.restart);
		
		

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);

		
		}

		// TODO: Emit LogCat message
		Log.i(tag(), CREATE_LOG_TEXT);

		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		displayCounts();

		
	}
	// Lifecycle callback overrides

		@Override
		public void onStart() {
			super.onStart();
			
			// TODO: Emit LogCat message
			Log.i(tag(), START_LOG_TEXT);
			
			// TODO:
			// Update the appropriate count variable
			// Update the user interface
			mStart++;
			displayCounts();
			

		}

		@Override
		public void onResume() {
			super.onResume();
			
			// TODO: Emit LogCat message
			Log.i(tag(), RESUME_LOG_TEXT);
			

			// TODO:
			// Update the appropriate count variable
			// Update the user interface
			mResume++;
			displayCounts();
		}

		@Override
		public void onPause() {
			super.onPause();

			// TODO: Emit LogCat message
			Log.i(tag(), PAUSE_LOG_TEXT);
		}

		@Override
		public void onStop() {
			super.onStop();

			// TODO: Emit LogCat message
			Log.i(tag(), STOP_LOG_TEXT);

		}

		@Override
		public void onRestart() {
			super.onRestart();

			// TODO: Emit LogCat message
			Log.i(tag(), RESTART_LOG_TEXT );
			
			// TODO:
			// Update the appropriate count variable
			// Update the user interface
			mRestart++;
			displayCounts();

		}

		@Override
		public void onDestroy() {
			super.onDestroy();

			// TODO: Emit LogCat message
			Log.i(tag(), DESTROY_LOG_TEXT );


		}

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState) {
			// TODO:
			// Save state information with a collection of key-value pairs
			// 4 lines of code, one for every count variable
			savedInstanceState.putInt(RESTART_KEY, mRestart);
			savedInstanceState.putInt(RESUME_KEY, mResume);
			savedInstanceState.putInt(START_KEY, mStart);
			savedInstanceState.putInt(CREATE_KEY, mCreate);


		}
		
	// Updates the displayed counters
	public void displayCounts() {
		
		
		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
	
	protected String tag(){
		return TAG;
	}
	protected int currentActivityID(){
		return 0; //need to override it;
	}
}
