package com.example.sfeld.lauracoffee2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ImageView myImage = (ImageView) findViewById(R.id.imageView);
        myImage.setImageAlpha(15);

        Button displayText = (Button) findViewById(R.id.button);//get the id for button

        displayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputName = (EditText) findViewById(R.id.inputName);
                String editTextValue = inputName.getText().toString();

                EditText inputCoffee = (EditText) findViewById(R.id.inputCoffee);
                String sCoffee = inputCoffee.getText().toString();

                if ((inputName.getText().toString().matches("")) || (sCoffee.matches(""))) //check whether the entered text is not null
                {
                    Toast.makeText(getApplicationContext(), "Enter values for Name and Number of " +
                            "Coffees!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    EditText InputPrice = (EditText) findViewById(R.id.inputPrice);
                    String sPrice = InputPrice.getText().toString();

                    double nTotal;
                    nTotal = Integer.parseInt(sCoffee) * Double.parseDouble(sPrice);

                    EditText OutputName = (EditText) findViewById(R.id.outputName);
                    OutputName.setText("Order Summary for: " + editTextValue);

                    EditText OutputCoffee = (EditText) findViewById(R.id.outputCoffee);
                    OutputCoffee.setText("Total ($): " + nTotal);

                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        double nSmallPrice = 1.5;
        double nNormalPrice = 2;
        double nLargePrice = 2.5;

        EditText priceCoffee = (EditText) findViewById(R.id.inputPrice);

        if (id == R.id.menu_small){
            priceCoffee.setText("" + nSmallPrice);

            return true;
        }

        if (id == R.id.menu_normal) {
            priceCoffee.setText("" + nNormalPrice);

            return true;
        }

        if (id == R.id.menu_large) {
            priceCoffee.setText("" + nLargePrice);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
