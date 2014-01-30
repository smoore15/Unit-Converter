package edu.brandeis.cs.samuelmoore.helloconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity);	
        
        //---Button View---
        Button button1 = (Button) findViewById(R.id.startButton);
        button1.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v)
        	{
        		Intent intent = new Intent(MainActivity.this, SecondWindow.class);
        		startActivity(intent);
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
