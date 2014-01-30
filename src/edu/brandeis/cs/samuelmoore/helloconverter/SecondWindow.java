package edu.brandeis.cs.samuelmoore.helloconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SecondWindow extends Activity{	
	public enum Type {
	    Centimeters, Inches, Feet, Yards,
	    Meters, Miles, Kilometers 
	}
	Type inputType;
	Type outputType;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondwindow);
        
        //Input spinner -- selects the unit of the input
        Spinner input = (Spinner) findViewById(R.id.second_window_input_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.second_window_units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        input.setAdapter(adapter);
        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
        	 @Override
			public void onItemSelected(AdapterView<?> parent, View view, 
        	            int pos, long id) {
        	        // An item was selected. You can retrieve the selected item using
        	        // parent.getItemAtPosition(pos)
        		 	String inputTypeS = parent.getItemAtPosition(pos).toString();
        		 	if (inputTypeS.equals("Centimeters")){
        		 		inputType = Type.Centimeters;
        		 	}
        		 	else if (inputTypeS.equals("Inches")){
        		 		inputType = Type.Inches;
        		 	}
        		 	else if (inputTypeS.equals("Feet")){
        		 		inputType = Type.Feet;
        		 	}
        		 	else if (inputTypeS.equals("Yards")){
        		 		inputType = Type.Yards;
        		 	}
        		 	else if (inputTypeS.equals("Meters")){
        		 		inputType = Type.Meters;
        		 	}
        		 	else if (inputTypeS.equals("Miles")){
        		 		inputType = Type.Miles;
        		 	}
        		 	else {
        		 		inputType = Type.Kilometers;
        		 	}
        	    }
        	@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				inputType = Type.Centimeters;
				
			}
        });
        
        //Output spinner -- selects the unit of the input
        Spinner output = (Spinner) findViewById(R.id.second_window_output_spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.second_window_units_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        output.setAdapter(adapter2);
        output.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
        	 @Override
			public void onItemSelected(AdapterView<?> parent, View view, 
        	            int pos, long id) {
        	        // An item was selected. You can retrieve the selected item using
        	        // parent.getItemAtPosition(pos)
        		 String outputTypeS = parent.getItemAtPosition(pos).toString();
     		 	if (outputTypeS.equals("Centimeters")){
     		 		outputType = Type.Centimeters;
     		 	}
     		 	else if (outputTypeS.equals("Inches")){
     		 		outputType = Type.Inches;
     		 	}
     		 	else if (outputTypeS.equals("Feet")){
     		 		outputType = Type.Feet;
     		 	}
     		 	else if (outputTypeS.equals("Yards")){
     		 		outputType = Type.Yards;
     		 	}
     		 	else if (outputTypeS.equals("Meters")){
     		 		outputType = Type.Meters;
     		 	}
     		 	else if (outputTypeS.equals("Miles")){
     		 		outputType = Type.Miles;
     		 	}
     		 	else {
     		 		outputType = Type.Kilometers;
     		 	}
        		 	
        		 	
        		 	
        	    }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				outputType = Type.Centimeters;
				
			}
        });
   
        
        //Clear Button -- upon click, this clears the input and output fields.
        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v)
        	{
        		EditText input = (EditText) findViewById(R.id.input);
        		input.setText(null);
        		EditText output = (EditText) findViewById(R.id.output);
        		output.setText(null);
        	}
        }); 
        
        //Convert Button -- upon click, this takes the input field and converts it and puts the result in the output field.
        Button convert = (Button) findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v)
        	{
        		EditText input = (EditText) findViewById(R.id.input);
        		EditText output = (EditText) findViewById(R.id.output);
        		
        		double inputConv;
        		
        		if (input.getText().toString()!=null)
        		{
        			inputConv = Double.parseDouble(input.getText().toString());
        			switch(inputType) //converts the input to centimeters
        			{
        				case Centimeters:	break;
        				
        				case Inches:	inputConv = inputConv * 2.54;
        								break;
                		case Feet:		inputConv = inputConv * 30.48;
                						break;
           				case Yards:		inputConv = inputConv * 91.44;
        								break;
        				case Meters:	inputConv = inputConv * 100;
        								break;
        				case Miles:		inputConv = inputConv * 160934.4;
        								break;
        				case Kilometers:	inputConv = inputConv * 100000.0;
        									break;
        				default:	break;
        			}
        			switch(outputType) //converts the input to centimeters
        			{
        				case Centimeters:	break;
        				
        				case Inches:	inputConv = inputConv / 2.54;
        								break;
                		case Feet:		inputConv = inputConv / 30.48;
                						break;
           				case Yards:		inputConv = inputConv / 91.44;
        								break;
        				case Meters:	inputConv = inputConv / 100;
        								break;
        				case Miles:		inputConv = inputConv / 160934.4;
        								break;
        				case Kilometers:	inputConv = inputConv / 100000.0;
        									break;
        				default:	break;
        			}
        			output.setText("" + inputConv);
        		}
        	}
        });
                
        //About button -- upon click, this displays an about dialog
        Button about = (Button) findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v)
        	{
        		Context context = SecondWindow.this;
        		CharSequence title = "About";
        		String message = "In order to use this app, please follow these instructions. Select a unit of measurement from the upper, or input, drop down menu, then select a different unit of measurement from the lower, or output, drop down menu. Type any numerical value into the input field. Press \'Convert\' and the app will perform the desired conversion.";
        		String button1String = "OK";
        		
        		AlertDialog.Builder ad = new AlertDialog.Builder(context);
        		ad.setTitle(title);
        		ad.setMessage(message);
        		ad.setIcon(0);
        		
        		ad.setPositiveButton(
        				button1String,
        				new DialogInterface.OnClickListener(){
        					@Override
							public void onClick(DialogInterface dialog, int arg1){
        						//do nothing
        					}
        				});
        		ad.show();
        	}
        });
        
        Button returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v)
        	{
//        		finish();
        		Context context = SecondWindow.this;
    			CharSequence title = "Last Conversion:";
    	    	EditText output = (EditText) findViewById(R.id.output);
    			String message = "The last conversion was " + output.getText().toString() + ".";
    			String button1String = "OK";
    			
    			AlertDialog.Builder ad = new AlertDialog.Builder(context);
    			ad.setTitle(title);
    			ad.setMessage(message);
    			ad.setIcon(0);
    			
    			ad.setPositiveButton(
    					button1String,
    					new DialogInterface.OnClickListener(){
    						@Override
							public void onClick(DialogInterface dialog, int arg1){
    							finish();
    						}
    					});
    			ad.show();
        	}
        });
    }
	
	
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.assignment2, menu);
	        return true;
	    }
}
