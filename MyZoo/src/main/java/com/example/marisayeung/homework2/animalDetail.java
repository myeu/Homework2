package com.example.marisayeung.homework2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class animalDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Intent intent = getIntent();
        String animal = intent.getStringExtra(animalList.ANIMAL_NAME);

        TextView name = (TextView) findViewById(R.id.animal_name);
        name.setText(animal);

        try {
            ImageView image = (ImageView) findViewById(R.id.animal_image);
            InputStream inputStream = getAssets().open(intent.getStringExtra(animalList.ANIMAL_IMG));
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            image.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView details = (TextView) findViewById(R.id.animal_detail);
        details.setText(intent.getStringExtra(animalList.ANIMAL_DESCRIPTION));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        getMenuInflater().inflate(R.menu.menu_animal_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuHelper.handleOnItemSelected(this, item);
    }

}
