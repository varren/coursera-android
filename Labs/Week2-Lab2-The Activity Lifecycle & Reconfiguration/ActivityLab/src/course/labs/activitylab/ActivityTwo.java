package course.labs.activitylab;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class ActivityTwo extends GenericActivity {

	// String for LogCat documentation
	private static final String TAG = "2: ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.w(tag(), "------------------------------------------------------");
				finish();
			}
		});
		
	}
	
	@Override
	protected String tag(){
		return TAG;
	}
	
	@Override
	protected int currentActivityID(){
		return R.layout.activity_two; //need to override it;
	}
}
