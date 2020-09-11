package com.example.gadsleaders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionConfirmation extends AppCompatActivity {

    String emailAddress;
    String firstName;
    String lastName;
    String github_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_confirmation);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        emailAddress = bundle.getString("EMAIL_ADDRESS");
        firstName = bundle.getString("FIRST_NAME");
        lastName = bundle.getString("LAST_NAME");
        github_link = bundle.getString("GITHUB_LINK");


        //Bundle bundle = getArguments();
        confirmation();


    }


    private void successDialog() {
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Submission Successful")
                .setCustomImage(R.drawable.success)
                .hideConfirmButton()
                .show();
    }

    private void errorDialog() {
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Submission not successful")
                .setCustomImage(R.drawable.error)
                .hideConfirmButton()
                .show();
    }


    private void confirmation() {
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure ?")
                .setConfirmButtonBackgroundColor(Color.rgb(250, 162, 43))
                .setConfirmClickListener(sweetAlertDialog -> {
                    submitProjectToGoogleForm(emailAddress, firstName, lastName, github_link);
                    sweetAlertDialog.dismissWithAnimation();
                }).show();
    }


    public void submitProjectToGoogleForm(String email, String name, String lastName, String githubLink) {

        Call<ProjectEntryForm> formToGoogle = APiClient.submitProject().submitProject(email, name, lastName, githubLink);

        formToGoogle.enqueue(new Callback<ProjectEntryForm>() {
            @Override
            public void onResponse(Call<ProjectEntryForm> call, Response<ProjectEntryForm> response) {
                // progressBtn.setVisibility(View.GONE);

                successDialog();

            }

            @Override
            public void onFailure(Call<ProjectEntryForm> call, Throwable t) {
                //progressBtn.setVisibility(View.GONE);
                errorDialog();


            }
        });

    }


}