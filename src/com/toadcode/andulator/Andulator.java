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
	
	//constants
	private final int ADD = 1;
	private final int SUBTRACT = 2;
	private final int MULTIPLY = 3;
	private final int DIVIDE = 4;
	
	//instance variables
	private TextView resultTextView;
	private Button clearButton;
	private Button divideButton;
	private Button equalsButton;
	private Button addButton;
	private Button subtractButton;
	private Button multiplyButton;
	
	//keeps track of the current operation
	private int currentOperator;
	private int firstNumber;
	private int result;
	
	
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
        
        //get a reference to the divide button
        divideButton = (Button) findViewById(R.id.btnDivide);
        divideButton.setOnClickListener(this);
        
        
        // get a reference to the add button 
        addButton = (Button) findViewById(R.id.btnAdd);
        addButton.setOnClickListener(this);
        
        // get a reference to multiply button
        multiplyButton = (Button) findViewById(R.id.btnMultiply);
        multiplyButton.setOnClickListener(this);
        
        //get a reference to the subtract button
        subtractButton = (Button) findViewById(R.id.btnSubtract);
        subtractButton.setOnClickListener(this);
        
        //get a reference to the equals button
        equalsButton = (Button) findViewById(R.id.btnEquals);
        equalsButton.setOnClickListener(this);
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
    		case R.id.btnSubtract:
    			setOperator(SUBTRACT);
    			firstNumber = Integer.valueOf(String.valueOf(resultTextView.getText()));
    			resetDisplay();
    			break;
    		case R.id.btnDivide:
    			setOperator(DIVIDE);
    			firstNumber = Integer.valueOf(String.valueOf(resultTextView.getText()));
    			resetDisplay();
    			break;
    		case R.id.btnAdd:
    			setOperator(ADD);
    			firstNumber  = Integer.valueOf(String.valueOf(resultTextView.getText()));
    			resetDisplay();
    			break; 	
    		case R.id.btnMultiply:
    			setOperator(MULTIPLY);
    			firstNumber = Integer.valueOf(String.valueOf(resultTextView.getText()));
    			resetDisplay();
    			break;
    		case R.id.btnEquals:
    			calculateResult();
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
    
    private void setDisplay(String displayString){
    	resultTextView.setText(displayString);
    }
    
    private void setOperator(int operator){
    	currentOperator = operator;
    }
    
    private void calculateResult(){
    	switch(currentOperator){
    		case DIVIDE:
    			result = firstNumber / Integer.valueOf(String.valueOf(resultTextView.getText()));
    			setDisplay(String.valueOf(result));
    			break;
    		case SUBTRACT:
    			result = firstNumber - Integer.valueOf(String.valueOf(resultTextView.getText()));
    			setDisplay(String.valueOf(result));
    			break;
    		case ADD:
    			result = firstNumber + Integer.valueOf(String.valueOf(resultTextView.getText()));
    			setDisplay(String.valueOf(result));
    			break;
    		case MULTIPLY:
    			result  = firstNumber * Integer.valueOf(String.valueOf(resultTextView.getText()));
    			setDisplay(String.valueOf(result));
    			break;
    	}
    	
    
    }
    
}