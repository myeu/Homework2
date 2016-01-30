package com.example.marisayeung.homework2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by marisayeung on 1/29/16.
 */
public class AnimalAdapter extends ArrayAdapter<Animal> {

    private final List<Animal> animals;

    public AnimalAdapter(Context context, int resource, List<Animal> animals) {
        super(context, resource, animals);

        this.animals = animals;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = animals.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.linear_animal_row, null);

        TextView textView = (TextView) row.findViewById(R.id.rowText);
        textView.setText(animal.getName());

        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.rowImage);
            InputStream inputStream = getContext().getAssets().open(animal.getPictureName());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}
