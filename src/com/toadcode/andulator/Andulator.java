package com.toadcode.andulator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Andulator extends Activity implements OnClickListener {
	
	//instance variables
	private TextView resultTextView;
	private Button clearButton;
	
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
        
        //get a reference to the result TextView
        resultTextView = (TextView) findViewById(R.id.textResult);
               
        //get a reference to the clear button and set it's click listener
        clearButton = (Button) findViewById(R.id.btnClear);
        clearButton.setOnClickListener(this);
        
    }
    
    
    public void onClick(View v){
    	//when any button with a registered handler is clicked
    	//test which button has been clicked and act appropriately
    	switch(v.getId()){
    		case R.id.btn0:
    			addIntegerToDisplay(0);
    			break;
    		case R.id.btn1:
    			addIntegerToDisplay(1);
    			break;
    		case R.id.btn2:
    			addIntegerToDisplay(2);
    			break;
    		case R.id.btn3:
    			addIntegerToDisplay(3);
    			break;
    		case R.id.btn4:
    			addIntegerToDisplay(4);
    			break;
    		case R.id.btn5:
    			addIntegerToDisplay(5);
    			break;
    		case R.id.btn6:
    			addIntegerToDisplay(6);
    			break;
    		case R.id.btn7:
    			addIntegerToDisplay(7);
    			break;
    		case R.id.btn8:
    			addIntegerToDisplay(8);
    			break;
    		case R.id.btn9:
    			addIntegerToDisplay(9);
    			break;
    		case R.id.btnClear:
    			resetDisplay();
    			break;
    		default:
    			Log.i("button_click", "An unhandled button click occured.");
    	}
    }
    
    private void addIntegerToDisplay(int number){
    	//if it's zero, don't add another zero
	   	if (Integer.valueOf(String.valueOf(resultTextView.getText())) == 0){
			resultTextView.setText("");
		}
	   	//set the text to the old text + the new text
    	resultTextView.setText(resultTextView.getText() + String.valueOf(number));
    }
    
    private void resetDisplay(){
    	//reset display to show a single zero
    	resultTextView.setText("0");
    }
    
}