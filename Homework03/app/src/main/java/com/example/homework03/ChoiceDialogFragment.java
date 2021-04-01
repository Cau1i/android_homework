package com.example.homework03;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class ChoiceDialogFragment extends DialogFragment {
    private String[] genders = new String[]{"男", "女"};
    private ChoiceDialogFragment.NotifyDialogListener listener;


    public interface NotifyDialogListener {
        public void onDialogPositiveClicked(String gender);
    }

    public void setListener(ChoiceDialogFragment.NotifyDialogListener listener) {
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("选择对话框")
                .setItems(genders, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogPositiveClicked(genders[which]);
                    }
                });
        return builder.create();
    }
}
