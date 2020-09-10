package com.example.gadsleaders;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class DisplaySubmitForm extends AppCompatActivity {

    EditText emailAddress;
    EditText name;
    EditText lastName;
    EditText linkToGithub;
    Button confirmButton;
    ProgressBar progressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_submit_form);

        emailAddress = findViewById(R.id.emailEditText);
        name = findViewById(R.id.firstNameEditText);
        lastName = findViewById(R.id.lastNameEditText);
        linkToGithub = findViewById(R.id.githubLinkEditText);
        confirmButton = findViewById(R.id.confirmButton);

        progressBtn = findViewById(R.id.submitProgressBar);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmation();
            }
        });
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
                    sendConfirmation();
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

    private void sendConfirmation() {
        String emailAddr = emailAddress.getText().toString();
        String nameField = name.getText().toString();
        String lastNameField = lastName.getText().toString();
        String githubLink = linkToGithub.getText().toString();
        submitProjectToGoogleForm(emailAddr, nameField, lastNameField, githubLink);
    }
}