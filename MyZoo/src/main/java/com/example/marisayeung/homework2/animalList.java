package com.example.marisayeung.homework2;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class animalList extends AppCompatActivity {

    public final static String ANIMAL_NAME = "MyZoo.animal_name";
    public final static String ANIMAL_IMG = "MyZoo.animal_img";

    private Animal alert_animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        ListView listView = (ListView) findViewById(R.id.custom_animal_list_view);

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("elephant.jpg", "Elephant"));
        animals.add(new Animal("alpaca.jpg", "Alpaca"));
        animals.add(new Animal("giraffe.jpg", "Giraffe"));
        animals.add(new Animal("monkey.jpg", "Monkey"));
        animals.add(new Animal("flamingo.jpg", "Flamingo"));
        animals.add(new Animal("pig.jpg", "Pig"));
        animals.add(new Animal("rhino.jpg", "Rhino"));
        animals.add(new Animal("wolf.jpg", "Wolf"));
        animals.add(new Animal("fox.jpg", "Fox"));
        animals.add(new Animal("kangaroo.jpg", "Kangaroo"));
        animals.add(new Animal("bobcat.jpg", "Bobcat"));
        animals.add(new Animal("crane.jpg", "Crane"));
        animals.add(new Animal("zebu.jpg", "Zebu"));
        animals.add(new Animal("duckling.jpg", "Duckling"));

        AnimalAdapter animalAdapter = new AnimalAdapter(this, R.layout.linear_animal_row, animals);
        listView.setAdapter(animalAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Animal animal = (Animal) adapter.getItemAtPosition(position);

                if (animal.getName().equals("Duckling")) {
                    AnimalDangerDialogFragment fragment = new AnimalDangerDialogFragment();
                    fragment.show(getFragmentManager(), "danger");
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
        startActivity(intent);
    }

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
