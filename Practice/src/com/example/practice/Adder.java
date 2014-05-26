package com.example.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Adder extends Activity {
Button b1,b2;
TextView t1;
int counter;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adder);
	    b1=(Button)findViewById(R.id.b1);
	    b2=(Button)findViewById(R.id.b2);
	    t1=(TextView)findViewById(R.id.text);
	    counter=0;
	    b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter=counter+1;
				t1.setText("Score is "+counter);
			}
		});
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				counter=counter-1;
				t1.setText("Score is "+counter);
			}
		});
//	t1.setText("Score is "+counter);

   }
}
