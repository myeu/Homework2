package com.example.marisayeung.homework2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class animalList extends AppCompatActivity {

    public final static String ANIMAL_NAME = "com.example.marisyeung.homework2.ANIMAL_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        ListView listView = (ListView) findViewById(R.id.custom_animal_list_view);

        Log.d("mine", "listView: " + listView);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("elephant.jpg", "Elephant"));
        animals.add(new Animal("alpaca.jpg", "Alpaca"));
        animals.add(new Animal("giraffe.jpg", "Giraffe"));
        animals.add(new Animal("monkey.jpg", "Monkey"));
        AnimalAdapter animalAdapter = new AnimalAdapter(this, R.layout.linear_animal_row, animals);
        listView.setAdapter(animalAdapter);

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
    }

    public void viewDetail(View view) {
        Intent intent = new Intent(this, animalDetail.class);
        TextView nameView = (TextView) findViewById(R.id.rowText);
        String name = nameView.getText().toString();
        intent.putExtra(ANIMAL_NAME, name);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animal_list, menu);
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
