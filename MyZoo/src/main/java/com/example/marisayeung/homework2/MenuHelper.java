package com.example.marisayeung.homework2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by marisayeung on 1/31/16.
 *
 */
public class MenuHelper {
    public static boolean handleOnItemSelected(Context context, MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_uninstall) {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }

        if (id == R.id.action_zoo_information) {
            //Log.d("mine", "context package name: " + context.getLocalClassName());
            Intent intent = new Intent(context, ZooInformation.class);
            context.startActivity(intent);
        }

        return true;
    }
}
