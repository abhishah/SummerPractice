package com.example.practice;
import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class List extends ListActivity {
	String classes[]={"Adder","splash","Textplay","Email","Camera","Data","GFX","GFXSurface","Soundpool","Slidding","Tabs","SimpleBrowser","ViewFlip","ExternalData","InternalData","SQLiteExample","Accelerate"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//Fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//WindowManager.LayoutParams.FLAG_FULLSCREEN
	    
		setListAdapter(new ArrayAdapter<String>(List.this,android.R.layout.simple_list_item_1, classes));
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{String loc=classes[position];
		Class our = Class.forName("com.example.practice."+loc);
		Intent newIntent=new Intent(List.this,our);
		startActivity(newIntent);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
	    super.onCreateOptionsMenu(menu);
		MenuInflater extras= getMenuInflater();
		extras.inflate(R.menu.classi, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.aboutus:
			Intent i= new Intent("com.example.practice.About");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent j= new Intent("com.example.practice.Prefs");
			startActivity(j);
			break;
		case R.id.exit:
			finish();
			break;
		}return false;
	}
 

}
