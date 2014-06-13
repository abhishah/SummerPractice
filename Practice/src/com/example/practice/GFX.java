package com.example.practice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity {
    MyBringBack anti;
    WakeLock wk;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		PowerManager pW=(PowerManager)getSystemService(Context.POWER_SERVICE);
		wk=pW.newWakeLock(PowerManager.FULL_WAKE_LOCK, "nothing");
		
		super.onCreate(savedInstanceState);
		wk.acquire();
	   anti= new MyBringBack(this);
	   setContentView(anti);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wk.release();
	}

	

}
