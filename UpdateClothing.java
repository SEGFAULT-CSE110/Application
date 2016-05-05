package com.example.admin.closet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

public class UpdateClothing extends AppCompatActivity {

    private Spinner category;
    private Spinner weather;
    private Spinner occasion;

    private CheckBox dirty;
    private CheckBox shared;
    private CheckBox lost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_clothing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String [] cat_array = new String[]{"Category", "Top", "Bottom", "Shoe", "Dress", "Accessory"};
        initSpinner(category,R.id.Category,cat_array);

        String [] weat_array = new String[]{"Weather", "Warm", "Cold", "Neutral", "Rain"};
        initSpinner(weather,R.id.Weather,weat_array);

        String[] occ_array = new String[]{"Occasion", "Casual", "Formal", "Business", "Fitness"};
        initSpinner(occasion,R.id.Occasion,occ_array);

    }

    protected void initSpinner (Spinner sp, int resource, String []arr){
        sp = (Spinner) findViewById(resource);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arr);

        // Specify the layout to use when the list of choices appears
        adapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        sp.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_clothing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
