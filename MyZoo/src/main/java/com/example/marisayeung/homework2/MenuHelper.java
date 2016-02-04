package com.example.marisayeung.homework2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;

/**
 * Created by Marisa Yeung on 1/29/16.
 *
 * Takes the action chosen from the menu
 *
 * Using a helper to avoid repeating this code for every activity
 *
 */

public class MenuHelper {
    public static boolean handleOnItemSelected(Context context, MenuItem item) {
        int id = item.getItemId();

//      Uninstall the app
        if (id == R.id.action_uninstall) {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
//      Show info about the Zoo
        if (id == R.id.action_zoo_information) {
            Intent intent = new Intent(context, ZooInformation.class);
            context.startActivity(intent);
        }

        return true;
    }
}
