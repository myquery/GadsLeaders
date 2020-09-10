package com.example.gadsleaders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String emailAddr = emailAddress.getText().toString();
                String nameField = name.getText().toString();
                String lastNameField = lastName.getText().toString();
                String githubLink = linkToGithub.getText().toString();
                submitProjectToGoogleForm(emailAddr, nameField, lastNameField, githubLink);
            }
        });
    }


    public void submitProjectToGoogleForm(String email, String name, String lastName, String githubLink) {
        progressBtn.setVisibility(View.VISIBLE);

        ProjectEntryForm projectEntryForm = new ProjectEntryForm();

        Call<ProjectEntryForm> formToGoogle = APiClient.submitProject().submtProject(projectEntryForm);

        formToGoogle.enqueue(new Callback<ProjectEntryForm>() {
            @Override
            public void onResponse(Call<ProjectEntryForm> call, Response<ProjectEntryForm> response) {
                progressBtn.setVisibility(View.GONE);

                Toast.makeText(DisplaySubmitForm.this, "Entry Submitted", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<ProjectEntryForm> call, Throwable t) {
                progressBtn.setVisibility(View.GONE);
                Toast.makeText(DisplaySubmitForm.this, "Error submitting Entry" + t, Toast.LENGTH_LONG).show();


            }
        });

    }
}