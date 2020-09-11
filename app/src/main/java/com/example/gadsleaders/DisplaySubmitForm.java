package com.example.gadsleaders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class DisplaySubmitForm extends AppCompatActivity {

    private static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
    private static final String FIRST_NAME = "FIRST_NAME";
    private static final String LAST_NAME = "LAST_NAME";
    private static final String GITHUB_LINK = "GITHUB_LINK";
    EditText emailAddress;
    EditText name;
    EditText lastName;
    EditText linkToGithub;
    Button confirmButton;
    ProgressBar progressBtn;

    //static property to store thr form fields
    //property of the form field value
    String emailAddr;
    String nameField;
    String lastNameField;
    String githubLink;

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
                sendConfirmation();
                Intent intent = new Intent(DisplaySubmitForm.this, SubmissionConfirmation.class);
                Bundle bundle = new Bundle();
                bundle.putString(EMAIL_ADDRESS, emailAddr);
                bundle.putString(FIRST_NAME, nameField);
                bundle.putString(LAST_NAME, lastNameField);
                bundle.putString(GITHUB_LINK, githubLink);
                intent.putExtras(bundle);
                startActivity(intent);
                //confirmation();
            }
        });
    }

    public void sendConfirmation() {
        emailAddr = emailAddress.getText().toString();
        nameField = name.getText().toString();
        lastNameField = lastName.getText().toString();
        githubLink = linkToGithub.getText().toString();
        //submitProjectToGoogleForm(emailAddr, nameField, lastNameField, githubLink);
    }


}