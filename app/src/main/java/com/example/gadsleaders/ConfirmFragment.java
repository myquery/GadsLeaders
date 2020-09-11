package com.example.gadsleaders;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ConfirmFragment extends DialogFragment {

    Button confirm;
    Dialog dialog;

    public ConfirmFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        try {
            dialog = super.onCreateDialog(savedInstanceState);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AppDialogTheme);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_confirm2, null);
            builder.setView(v);
            return builder.create();
        } catch (Exception e) {
            Log.e("failure", "", e);
            return null;
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        // dialog.show();
        ((DisplaySubmitForm) getActivity()).confirmation();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_confirm2, container, false);
        // confirm = (Button) view.findViewById(R.id.confirm_submission_form);
        return view;
    }


//    private void confirmSubmissionForm(){
//        confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((DisplaySubmitForm)getActivity()).sendConfirmation(DisplaySubmitForm.getConfirmTrigger);
//            }
//        });
//    }


}