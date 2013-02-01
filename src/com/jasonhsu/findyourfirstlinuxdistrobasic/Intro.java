package com.jasonhsu.findyourfirstlinuxdistrobasic;

//The import commands do not need to be typed manually.
//Ctrl-Shift-O automatically adds them.
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Intro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
	}
	
    // Provide the option of running the SelectDistro.java script
    // This option is exercised when you press the Continue button.
    public void showOptions(View v) {
    	startActivity(new Intent(this, SelectDistro.class));
    	}

}
