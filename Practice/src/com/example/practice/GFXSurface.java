package com.example.practice;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GFXSurface extends Activity implements OnTouchListener{
MyBringBackSurface mysurface;
public float x,y,sX,sY,fX,fY;
Bitmap test,plus;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mysurface=new MyBringBackSurface(this);
		mysurface.setOnTouchListener(this);
		x=0;
		y=0;
		sX=0;
		sY=0;
		fX=0;
		fY=0;
	    test=BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
		plus=BitmapFactory.decodeResource(getResources(), R.drawable.plus);
		setContentView(mysurface);
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mysurface.pause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mysurface.resume();
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		x=arg1.getX();
		y=arg1.getY();
		switch(arg1.getAction()){
		case MotionEvent.ACTION_DOWN:
		sX=arg1.getX();
		sY=arg1.getY();
		break;
		case MotionEvent.ACTION_UP:
		fY=arg1.getY();
		fX=arg1.getX();
		break;
		}
		return true;
	}
	

 class MyBringBackSurface extends SurfaceView implements Runnable{
SurfaceHolder surface;
Thread back;
boolean isRunning=true; 
	public MyBringBackSurface(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		surface=getHolder();
		
	}

	public void pause(){
		isRunning=false;
		while(true){
			try {
				back.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}break;
		}back=null;
	}
	public void resume(){
		isRunning=true;
		back=new Thread(this);
		back.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning){
			if(!surface.getSurface().isValid()){
				continue;
			}
			Canvas canvas=surface.lockCanvas();
			canvas.drawColor(Color.BLACK);
			if( x != 0 && y != 0){
				
			canvas.drawBitmap(test, x-(test.getWidth()/2), y-(test.getHeight()/2), null);
			}
			if( sX != 0 && sY != 0){
				
				canvas.drawBitmap(plus, sX-(plus.getWidth()/2), sY-(plus.getHeight()/2), null);
				}
			if( fX != 0 && fY != 0){
				
				canvas.drawBitmap(plus, fX-(plus.getWidth()/2), fY-(plus.getHeight()/2), null);
				
				}
			surface.unlockCanvasAndPost(canvas);
		}
	}

}
}
