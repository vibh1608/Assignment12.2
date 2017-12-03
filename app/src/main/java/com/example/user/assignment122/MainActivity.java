package com.example.user.assignment122;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //creating object to link with UI componenets
    EditText mName,mAge,mPhone,mCity;
    Button mSave,mShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting reference to all the edittext
        mName=findViewById(R.id.name);
        mAge=findViewById(R.id.age);
        mPhone=findViewById(R.id.phone);
        mCity=findViewById(R.id.city);

        //setting reference of buttons with UI buttons
        mSave=findViewById(R.id.Save);
        mShow=findViewById(R.id.Show);

        //on click of save button setting listener
        mSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //creating object of Sharedpreference class to store data with name key
                SharedPreferences name= getSharedPreferences("name",MODE_PRIVATE);
                SharedPreferences.Editor m_name = name.edit();
                m_name.putString("name",mName.getText().toString());
                m_name.commit();

                //creating object of Sharedpreference class to store data with age key
                SharedPreferences age = getSharedPreferences("age",MODE_PRIVATE);
                SharedPreferences.Editor m_age = age.edit();
                m_age.putString("age",mAge.getText().toString());
                m_age.commit();

                //creating object of Sharedpreference class to store data with phone key
                SharedPreferences phone = getSharedPreferences("phone",MODE_PRIVATE);
                SharedPreferences.Editor m_phone = phone.edit();
                m_phone.putString("phone",mPhone.getText().toString());
                m_phone.commit();

                //creating object of Sharedpreference class to store data with city key
                SharedPreferences city = getSharedPreferences("city",MODE_PRIVATE);
                SharedPreferences.Editor m_city = city.edit();
                m_city.putString("city",mCity.getText().toString());
                m_city.commit();
            }
        });

        //on click of show button setting listener
        mShow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //creating objects of Sharedpreferences class to retrive data from corresponding key value
                SharedPreferences name = getSharedPreferences("name",MODE_PRIVATE);
                SharedPreferences age = getSharedPreferences("age",MODE_PRIVATE);
                SharedPreferences phone = getSharedPreferences("phone",MODE_PRIVATE);
                SharedPreferences city = getSharedPreferences("city",MODE_PRIVATE);

                //storing all data to show in toast message in string form
                String info ="Name: "+name.getString("name","")+"\nAge: "+age.getString("age","")
                        + "\nPhone:"+phone.getString("phone","")+"\nCity: "+city.getString("city","");

                //Toast message to show data
                Toast.makeText(MainActivity.this,info,Toast.LENGTH_LONG).show();
            }
        });
    }
}
