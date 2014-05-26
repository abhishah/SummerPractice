package com.example.practice;

import android.app.Activity;
import android.os.Bundle;

public class GFX extends Activity {
    MyBringBack anti;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	   anti= new MyBringBack(this);
	   setContentView(anti);
	}

	

}
