package com.example.marisayeung.homework2;

import android.view.MenuItem;

/**
 * Created by marisayeung on 1/31/16.
 */
public class MenuHelper {
    public static boolean handleOnItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_uninstall) {
            return true;
        }

        if (id == R.id.action_zoo_information) {
            return true;
        }

        return true;
    }
}
