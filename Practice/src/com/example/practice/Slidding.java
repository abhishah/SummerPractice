package com.example.practice;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

@SuppressWarnings("deprecation")
public class Slidding extends Activity implements OnClickListener,OnCheckedChangeListener, OnDrawerOpenListener{
	SlidingDrawer sb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidding);
		Button b1=(Button)findViewById(R.id.handle1);
		Button b2=(Button)findViewById(R.id.handle2);
		Button b3=(Button)findViewById(R.id.handle3);
		CheckBox cb=(CheckBox)findViewById(R.id.cbSlidable);
	    sb=(SlidingDrawer)findViewById(R.id.slidingD);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		cb.setOnCheckedChangeListener(this);
		sb.setOnDrawerOpenListener(this);
	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if(arg0.isChecked()){sb.lock();}else{sb.unlock();}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.handle1:
			sb.open();
			break;
		case R.id.handle2:
			sb.toggle();
			break;
		case R.id.handle3:
			sb.close();
			break;
		
		}
		
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		if(sb.isOpened()){MediaPlayer mp=MediaPlayer.create(this, R.raw.explosion);
		mp.start();}
	}

}
