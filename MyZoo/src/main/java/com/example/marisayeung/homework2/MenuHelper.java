package com.example.marisayeung.homework2;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

/**
 * Created by marisayeung on 1/31/16.
 */
public class MenuHelper {
    public static boolean handleOnItemSelected(Context context, MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_uninstall) {
            return true;
        }

        if (id == R.id.action_zoo_information) {
            Intent intent = new Intent(context, ZooInformation.class);
            context.startActivity(intent);
            return true;
        }

        return true;
    }
}
