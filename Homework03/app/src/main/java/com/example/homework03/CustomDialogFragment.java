package com.example.homework03;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    private EditText editTextName1;
    private EditText editTextName2;
    private CustomDialogFragment.NotifyDialogListener listener;

    public interface NotifyDialogListener {
        public void onDialogPositiveClicked(String editTextName1, String editTextName2);
    }

    public void setListener(CustomDialogFragment.NotifyDialogListener listener) {
        this.listener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_dialog, null);

        editTextName1 = (EditText) layout.findViewById(R.id.editTextName01);
        editTextName2 = (EditText) layout.findViewById(R.id.editTextName02);
        
        builder.setView(layout)
                .setTitle("自定义对话框")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onDialogPositiveClicked(editTextName1.getText().toString(), editTextName2.getText().toString());
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity().getApplicationContext(), "你取消了！", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }


}
