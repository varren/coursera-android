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

public class ActivityOne extends GenericActivity {

	// String for LogCat documentation
	private static final String TAG = "1: |                 ";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.w(tag(), "+++++++++++++++++++++++++++++++++++++++++++++");
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method
				
				// Create an intent stating which Activity you would like to start
				Intent intent = new Intent(getCurrentContext(), ActivityTwo.class);
				
				// Launch the Activity using the intent
				startActivity(intent);
			
			}
		});	
	}
	
	@Override
	protected String tag(){
		return TAG;
	}
	@Override
	protected int currentActivityID(){
		return R.layout.activity_one; //need to override it;
	}
	

}
