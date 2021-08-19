package com.example.mykeyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

//1.implements an interface (View.OnClick Listener) which allows us to handle onclick events on our calendar picker dialog
//7.0 Implement interface (AdapterView.onItemSelectedListener)
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
//2.Declare an EditText variable that is the focus of the calendar dialogue
    private EditText birthday;

    //5.Declare the variables to hold the selected variables(day,month,year)
    private int mYear;
    private int mDay;
    private int mMonth;

    //7.6 Declare a variable for holding a variable selected on the spinner
    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3.Connect the EditText you created with the one specified in the layout for receiving the date value
        birthday = findViewById(R.id.birthday);
        //4.Connect the EditText variable with the OnClickListener
        birthday.setOnClickListener(this);

        //7.1 Declare a spinner variable amd connect it with the spinner view in the layout
        Spinner phoneSpinner = findViewById(R.id.phone_spinner);
        //7.2 Set an onItemSelectedListener on the spinner object/variable you have created
        if(phoneSpinner != null){
            phoneSpinner.setOnItemSelectedListener(this);
        }

        //7.3 Create an array Adapter using the String array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_label, android.R.layout.simple_spinner_item);
        //7.4 Specify the layout for dropdown menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //7.5 Attach the spinner to the adapter
        if(phoneSpinner != null){
            phoneSpinner.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
        //6.To get the instance of thr current state
        //6.1 Ensure the focus is on the EditText variable birthday
        if(v==birthday){
            //6.2 Declare a calendar to get current selected date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            //6.3 Declare a data picker dialog to pick selected Date
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    //6.4 Set the date on the EditText variable
                    birthday.setText(dayOfMonth+"-"+(month+1+"-"+year));
                }
            },mYear,mMonth,mDay);
            //6.5 Show the date picker dialog
            datePickerDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //7.6 Declare a variable for holding a variable selected on the spinner
        //7.7 Use the method getItemAtPosition() to get the label selected
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        //7.8 Something to do with the item selected
        Toast myToast= Toast.makeText(this,"Selected phone as:" +mSpinnerLabel,Toast.LENGTH_SHORT);
        myToast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //7.9 Something to do
        Toast toast=Toast.makeText(this,"nothing selected",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showToast(View view) {
        Toast check = Toast.makeText(this,"Please Accept Terms And Conditions",Toast.LENGTH_SHORT);
        check.show();
    }

    public void createAccount(View view) {
        //Compare password
        //through error exception
        //get the data on the edittext and insert into a database
        //add an intent and open MainActivity
        //Throw a toast
        Toast submit = Toast.makeText(this,"Account Creation Successfull",Toast.LENGTH_SHORT);
        submit.show();
    }
}