package com.example.marisayeung.homework2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by marisayeung on 2/1/16.
 */
public class AnimalDangerDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.dialog_animal_danger)
                .setPositiveButton(R.string.proceed, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        ((animalList) getActivity()).onYes();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.go_back, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.cancel();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
