package com.example.magnum.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1,spinner2;
    Button btnSubmit;

    int selection1,selection2,selection3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

        //s1 = (Spinner) findViewById(R.id.spinner1);


    }

    public void addItemsOnSpinner2(int sel) {

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        List<String> list = new ArrayList<String>();
        switch (sel) {
            case 0:
                list.add("Btech North");
                list.add("Btech South");
            break;
            case 1:
                list.add("MBA North");
                list.add("MBA South");
                break;
            default:
                list.add("Defualt A");
                list.add("Default B");
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {

        selection1=0;

        class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
                        selection1=pos;
                Log.d("selection1"," " + selection1);
                addItemsOnSpinner2(selection1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        }

        Log.d("selection1 after toast "," " + selection1);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        //addItemsOnSpinner2(selection1);


    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
       // spinner3=   (Spinner) findViewById(R.id.spinner3);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*
                Toast.makeText(this,
                        "OnClickListener : " +
                                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) +
                                "\nSpinner 2 : "+ String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
                */
                Log.d("Selected items : ", String.valueOf(spinner1.getSelectedItem())+ " " + String.valueOf(spinner2.getSelectedItem()));


            }

        });
    }


    /*
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }
    */

}
