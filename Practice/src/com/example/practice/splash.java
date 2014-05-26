package com.example.practice;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class splash extends Activity {
MediaPlayer song;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		song=MediaPlayer.create(splash.this,R.raw.demons);
		SharedPreferences play=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean sing=play.getBoolean("check", true);
		if(sing==true)
		song.start();
	    Thread act= new Thread(){
	    	@Override
			public void run(){
	    		try{sleep(1000);
	    	}catch(InterruptedException e){
	    		e.printStackTrace();
	    	}finally {Intent a=new Intent("com.example.practice.LIST");
	    startActivity(a);
	    }
	   }
	};act.start();
       }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}
	
}

	


