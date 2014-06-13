package com.example.practice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewFlipper;
public class ViewFlip extends Activity implements OnClickListener{
	ViewFlipper vf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewflipper);
	    vf= (ViewFlipper) findViewById(R.id.viewFlipper);
		vf.setOnClickListener(this);
		vf.setFlipInterval(100);
		vf.startFlipping();
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		vf.showNext();
	}

}
