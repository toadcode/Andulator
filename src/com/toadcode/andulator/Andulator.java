package com.toadcode.andulator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class Andulator extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.i("event", "onCreate is done.");
        
        TableLayout rootTableLayout = (TableLayout) findViewById(R.id.tableLayout);
        
        int i = 0;
        int x = 0;
        
        //loop through all children in TableLayout
        for (i = 0; i < rootTableLayout.getChildCount(); i++){
        	//assign an object (this is the child)
        	Object childView = rootTableLayout.getChildAt(i);
        	//if it's a TableRow
        	if (childView instanceof TableRow){
        		//loop through all of the children in the TableRow
        		for (x = 0; x < ((TableRow) childView).getChildCount(); x++){
        			//assign the object (this is the child of the TableRow)
        			Object rowChild = ((TableRow) childView).getChildAt(x);
        			//if the child is a Button
        			if (rowChild instanceof Button){
        				//add a click listener
        				Log.i("event", "adding click listener");
        				((Button) rowChild).setOnClickListener(this);
        			}
        		}        		
        	}
        }
        
    }
    
    
    public void onClick(View v){
    	//when any button with a registered handler is clicked
    	Log.i("event", "view clicked");
    }
    
    
}