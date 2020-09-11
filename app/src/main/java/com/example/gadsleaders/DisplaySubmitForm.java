package com.example.gadsleaders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class DisplaySubmitForm extends AppCompatActivity {

    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    private static final String SUBMIT_TAG_BACK = "submit_fragment";
    private GetConfirmTrigger getConfirmTrigger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_submit_form);


        showSubmitProjectForm();
    }


    private void showSubmitProjectForm() {
        SubmitProjectFragment fragment = new SubmitProjectFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack(BACK_STACK_ROOT_TAG, 0);
        fragmentManager.beginTransaction()
                .add(R.id.submit_project_fragment_container, fragment)
                .addToBackStack(BACK_STACK_ROOT_TAG)
                .commit();
    }

    public void showDialogSubmitProject() {
        ConfirmFragment fragment = new ConfirmFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.submit_project_fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void successDialog() {
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Submission Successful")
                .setCustomImage(R.drawable.success)
                .hideConfirmButton()
                .show();
    }

    public void errorDialog() {
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Submission not successful")
                .setCustomImage(R.drawable.error)
                .hideConfirmButton()
                .show();
    }

    public void confirmation() {


        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure ?")
                .setConfirmButtonBackgroundColor(Color.rgb(250, 162, 43))
                .setConfirmClickListener(sweetAlertDialog -> {
                    sendConfirmation();
                    sweetAlertDialog.dismissWithAnimation();
                }).show();
    }


    public void sendConfirmation() {

        getConfirmTrigger.sendConfirmation();

    }

    public interface GetConfirmTrigger {
        void sendConfirmation();
    }


}