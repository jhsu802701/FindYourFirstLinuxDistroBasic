package com.jasonhsu.findyourfirstlinuxdistrobasic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SelectDistro extends Activity {
	
	Button ButtonSubmit;
	
	Spinner spinner_purpose, spinner_age, spinner_memory;
	String str_purpose, str_age, str_memory;
	
	String[] array_purpose, array_age, array_mem;
	
	String purpose_rescue;
	String age_vista, age_xp, age_98, age_95;
	String mem_vista, mem_xp, mem_98, mem_95;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		
		// Spinners: used to provide the user answers to the questions
		spinner_purpose = (Spinner)findViewById(R.id.spinnerPurpose);
		spinner_age = (Spinner)findViewById(R.id.spinnerAge);
		spinner_memory = (Spinner)findViewById(R.id.spinnerMemory);
		
		// Possible purposes
		array_purpose = getResources().getStringArray(R.array.purpose_array);
		purpose_rescue = array_purpose [0];
		
		// Possible ages of computer
		array_age = getResources().getStringArray(R.array.age_array);
		age_vista = array_age [0];
		age_xp = array_age [1];
		age_98 = array_age [2];
		age_95 = array_age [3];
		
		// Possible levels of memory
		array_mem = getResources().getStringArray(R.array.memory_array);
		mem_vista = array_mem [0];
		mem_xp = array_mem [1];
		mem_98 = array_mem [2];
		mem_95 = array_mem [3];
		
		// Submit button
		ButtonSubmit = (Button) findViewById(R.id.button_submit);
		
		// Response when the Submit button is clicked
		ButtonSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Get the selected answers on purpose, age, and memory
	    		str_purpose = String.valueOf(spinner_purpose.getSelectedItem());
	    		str_age = String.valueOf(spinner_age.getSelectedItem());
	    		str_memory = String.valueOf(spinner_memory.getSelectedItem().toString());
	    		
	    		// Possible solutions
	    		String solution;
	    		String sol_puppy, sol_tiny; 
	    		String sol_mint_ubuntu, sol_mint_deb, sol_antix, sol_museum;
	    		sol_puppy = getResources().getString(R.string.solution_puppy);
	    		sol_tiny = getResources().getString(R.string.solution_tinycore);
	    		sol_mint_ubuntu = getResources().getString(R.string.solution_mint_ubuntu);
	    		sol_mint_deb = getResources().getString(R.string.solution_mint_debian);
	    		sol_antix = getResources().getString(R.string.solution_antix);
	    		sol_museum = getResources().getString(R.string.solution_museum);
	    		
	    		// Process inputs and display solution through sendAnswerToActivity
	    		if (str_purpose.equals(purpose_rescue)) {
	    			if (str_memory.equals (mem_95)) {
	    				PrintResult (sol_tiny);
	    			}
	    			else {
	    				PrintResult (sol_puppy);
	    			}
	    		}
	    		else {
	    			if (str_memory.equals(mem_95) | str_age.equals(age_95)) {
	    				PrintResult (sol_museum);
	    			}
	    			else if (str_memory.equals(mem_98) | str_age.equals(age_98)) {
	    				PrintResult (sol_antix);
	    			}
	    			else if (str_memory.equals(mem_xp) | str_age.equals(age_xp)) {
	    				PrintResult (sol_mint_deb);
	    			}
	    			else {
	    				PrintResult (sol_mint_ubuntu);
	    			}
	    		}
			}
			
		});
	}
	
    private void PrintResult (String string_local) {
    	setContentView (R.layout.result);
    	TextView TextViewResult = (TextView)findViewById (R.id.textViewResult);
    	TextViewResult.setText (string_local);
    	
    }
}
