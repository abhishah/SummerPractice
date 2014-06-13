package com.example.practice;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class Soundpool extends Activity implements OnClickListener, OnLongClickListener {
SoundPool sp;
MediaPlayer mp;
int explosion=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v=new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this);
		setContentView(v);
		sp=new SoundPool(5,AudioManager.STREAM_MUSIC,0);
		explosion=sp.load(this, R.raw.explosion, 1);
		mp= MediaPlayer.create(this, R.raw.demons);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(explosion != 0)
		sp.play(explosion, 1, 1, 0, 0, 1);
	}

	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		if(mp.isPlaying()==true){
		   mp.pause();
		   return false;}
		mp.start();
		return false;
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(mp.isPlaying()==true)mp.stop();
	}

}
