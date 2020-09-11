package com.example.gadsleaders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SubmitProjectFragment extends Fragment implements DisplaySubmitForm.GetConfirmTrigger {

    View v;
    //  static void getSendConfirmation;

    EditText emailAddress;
    EditText name;
    EditText lastName;
    EditText linkToGithub;
    Button confirmButton;
    ProgressBar progressBtn;


    public SubmitProjectFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        //sendConfirmation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_submit_project, container, false);

        emailAddress = (EditText) v.findViewById(R.id.emailEditText);
        name = (EditText) v.findViewById(R.id.firstNameEditText);
        lastName = (EditText) v.findViewById(R.id.lastNameEditText);
        linkToGithub = (EditText) v.findViewById(R.id.githubLinkEditText);
        confirmButton = (Button) v.findViewById(R.id.confirmButton);

        progressBtn = (ProgressBar) v.findViewById(R.id.submitProgressBar);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DisplaySubmitForm) getActivity()).showDialogSubmitProject();
            }
        });

        return v;
    }

    public void submitProjectToGoogleForm(String email, String name, String lastName, String githubLink) {
        Call<ProjectEntryForm> formToGoogle = APiClient.submitProject().submitProject(email, name, lastName, githubLink);
//        progressBtn.setVisibility(View.VISIBLE);
        formToGoogle.enqueue(new Callback<ProjectEntryForm>() {
            @Override
            public void onResponse(Call<ProjectEntryForm> call, Response<ProjectEntryForm> response) {
                progressBtn.setVisibility(View.GONE);

                ((DisplaySubmitForm) getActivity()).successDialog();

            }

            @Override
            public void onFailure(Call<ProjectEntryForm> call, Throwable t) {
//                progressBtn.setVisibility(View.GONE);
                ((DisplaySubmitForm) getActivity()).errorDialog();


            }
        });

    }

    @Override
    public void sendConfirmation() {
        String emailAddr = emailAddress.getText().toString();
        String nameField = name.getText().toString();
        String lastNameField = lastName.getText().toString();
        String githubLink = linkToGithub.getText().toString();
        submitProjectToGoogleForm(emailAddr, nameField, lastNameField, githubLink);
    }


}