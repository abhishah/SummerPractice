package com.example.practice;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class MyBringBack extends View{
    Bitmap imager;
    float size;
    Typeface font;
	public MyBringBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		imager=BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
	    size=0;
	    font=Typeface.createFromAsset(context.getAssets(), "G-Unit.TTF");
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		Random a=new Random();
		Paint text=new Paint();
		int p,q,r;
		p=a.nextInt(250);
		q=a.nextInt(250);
		r=a.nextInt(250);
		text.setARGB(50,p,q ,r);
		text.setTextAlign(Align.CENTER);
	    text.setTextSize(45);
	    text.setTypeface(font);
	    canvas.drawText("Hi tried it out", canvas.getWidth()/2,100 , text);
		
		canvas.drawBitmap(imager,canvas.getWidth()/2 , size, null);
		if(size <canvas.getHeight()){
			size+=10;
		}else{size=0;}
		Rect arec=new Rect();
		arec.set(0, 400, canvas.getHeight(), 800);
		Paint ble=new Paint();
		ble.setColor(Color.BLUE);
		canvas.drawRect(arec, ble);
		invalidate();
	}

	

}
