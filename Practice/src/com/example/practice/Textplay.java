package com.example.practice;

import java.util.Random;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class Textplay extends Activity implements View.OnClickListener {
    ToggleButton active;
    EditText cmd;
    TextView text;
    Button chkcmd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acces);
		onStarting();
	    active.setOnClickListener(this);
		chkcmd.setOnClickListener(this);
		}

	private void onStarting() {
		// TODO Auto-generated method stub
		 chkcmd= (Button)findViewById(R.id.bt1);
		 active=(ToggleButton)findViewById(R.id.tb);
		 cmd=(EditText)findViewById(R.id.et1);
		 text=(TextView)findViewById(R.id.tv);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bt1:
			String input=cmd.getText().toString();
			text.setText(input);
			if(input.contentEquals("left")){
				text.setGravity(Gravity.LEFT);
				}
			else if(input.contentEquals("right")){
				text.setGravity(Gravity.RIGHT);
			    }
			else if(input.contentEquals("center")){
				text.setGravity(Gravity.CENTER);
			    }
			else if(input.contentEquals("random")){
				Random rnd=new Random();
				text.setTextSize(rnd.nextInt(45));
				text.setTextColor(Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
				switch(rnd.nextInt(3)){
				case 0:
					text.setGravity(Gravity.LEFT);
					break;
				case 1:
					text.setGravity(Gravity.CENTER);
					break;
				case 2:
					text.setGravity(Gravity.RIGHT);
					break;
				}
			    }
			else{ text.setGravity(Gravity.CENTER);
			      text.setText("invalid input");
			     }
			
	
			break;
		case R.id.tb:
			if(active.isChecked()){cmd.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PASSWORD);	
			}else{cmd.setInputType(InputType.TYPE_CLASS_TEXT );}
			break;
		// TODO Auto-generated method stub
		
	}}

	

}
