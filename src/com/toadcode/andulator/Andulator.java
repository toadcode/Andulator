package com.toadcode.andulator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Andulator extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i("event", "onCreate is done.");
        Button button = (Button)findViewById(R.id.btn0); 
        button.setOnClickListener(this);
    }
    
    
    public void onClick(View v){
    	//when any button with a registered handler is clicked
    	Log.i("event", "view clicked");
    	if (v.getId() == R.id.btn0){
    		//button 0 was clicked
    		Log.i("button_click", "button 0 was clicked!");
    	}
    }
    
    
}