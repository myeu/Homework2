package com.example.marisayeung.homework2;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marisa Yeung on 1/29/16.
 *
 * Activity that displays on launch.
 *
 * Displays a list of animals in a zoo, with image icon and name
 *
 */

public class animalList extends AppCompatActivity {

//    Easy handles for the unique extra names
    public final static String ANIMAL_NAME = "MyZoo.animal_name";
    public final static String ANIMAL_IMG = "MyZoo.animal_img";
    public final static String ANIMAL_DESCRIPTION = "MyZoo.animal_description";

//    save the animal that the dialog warns against
    private Animal alert_animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        ListView listView = (ListView) findViewById(R.id.custom_animal_list_view);

        Resources res = getResources();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("elephant.jpg", "Elephant", res.getString(R.string.elephant)));
        animals.add(new Animal("alpaca.jpg", "Alpaca", res.getString(R.string.Alpaca)));
        animals.add(new Animal("giraffe.jpg", "Giraffe", res.getString(R.string.Giraffe)));
        animals.add(new Animal("monkey.jpg", "Monkey", res.getString(R.string.Monkey)));
        animals.add(new Animal("flamingo.jpg", "Flamingo", res.getString(R.string.Flamingo)));
        animals.add(new Animal("pig.jpg", "Pig", res.getString(R.string.Pig)));
        animals.add(new Animal("rhino.jpg", "Rhino", res.getString(R.string.Rhino)));
        animals.add(new Animal("wolf.jpg", "Wolf", res.getString(R.string.Wolf)));
        animals.add(new Animal("fox.jpg", "Fox", res.getString(R.string.Fox)));
        animals.add(new Animal("kangaroo.jpg", "Kangaroo", res.getString(R.string.Kangaroo)));
        animals.add(new Animal("bobcat.jpg", "Bobcat", res.getString(R.string.Bobcat)));
        animals.add(new Animal("crane.jpg", "Crane", res.getString(R.string.Crane)));
        animals.add(new Animal("zebu.jpg", "Zebu", res.getString(R.string.Zebu)));
        animals.add(new Animal("duckling.jpg", "Duckling", res.getString(R.string.Duckling)));

        AnimalAdapter animalAdapter = new AnimalAdapter(this, R.layout.linear_animal_row, animals);
        listView.setAdapter(animalAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Animal animal = (Animal) adapter.getItemAtPosition(position);

//                Warn against the last animal in the list
                if (animal.getName().equals("Duckling")) {
                    AnimalDangerDialogFragment fragment = new AnimalDangerDialogFragment();
                    fragment.show(getFragmentManager(), "danger");
//                    this executes asynchronously, don't viewDetail here, save for later
                    alert_animal = animal;
                } else {
                    viewDetail(animal);
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void viewDetail(Animal animal) {
        Intent intent = new Intent(this, animalDetail.class);
        intent.putExtra(ANIMAL_NAME, animal.getName());
        intent.putExtra(ANIMAL_IMG, animal.getPictureName());
        intent.putExtra(ANIMAL_DESCRIPTION, animal.getDescription());
        startActivity(intent);
    }

//    Dialog box response was Yes proceed to animal detail
    public void onYes() {
        viewDetail(alert_animal);
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
        return MenuHelper.handleOnItemSelected(this, item);
    }
}
