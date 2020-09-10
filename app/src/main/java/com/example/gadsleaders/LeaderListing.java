package com.example.gadsleaders;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gadsleaders.ui.main.SectionsPagerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderListing extends AppCompatActivity {
    private static final String TOP_LEARNERS_LEADERS = "top_learning_leaders";
    public boolean learningLeaders = false;
    public boolean skillIq = false;
    public List<GadsLeader> gadsLeaders_list;
    public List<SkillLeader> skill_leaders_list;
    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager viewPager;
    Button submitEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_listing);

        submitEntry = findViewById(R.id.display_submit_form);

        submitEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LeaderListing.this, DisplaySubmitForm.class);
                startActivity(intent);
                finish();
            }
        });
        getGadsLearners();
        getSkillGadsLearners();
    }

    public void getGadsLearners() {
        Call<List<GadsLeader>> getLearnerFormApi = APiClient.getGadsLearners().getGadsLearningLeaders();
        getLearnerFormApi.enqueue(new Callback<List<GadsLeader>>() {
            @Override
            public void onResponse(Call<List<GadsLeader>> call, Response<List<GadsLeader>> response) {
                if (response.isSuccessful()) {

                    if (response.isSuccessful()) {
                        gadsLeaders_list = response.body();
                        learningLeaders = true;
                        updateUi();
                        Log.e("success", "this is arraylist size:" + gadsLeaders_list + "");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<GadsLeader>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());

            }
        });

    }


    public void getSkillGadsLearners() {
        Call<List<SkillLeader>> getLearnerFormApi = APiClient.getSkillLearners().getGadsSkillLeaders();
        getLearnerFormApi.enqueue(new Callback<List<SkillLeader>>() {
            @Override
            public void onResponse(Call<List<SkillLeader>> call, Response<List<SkillLeader>> response) {
                if (response.isSuccessful()) {

                    if (response.isSuccessful()) {
                        skill_leaders_list = response.body();
                        skillIq = true;
                        updateUi();
                        Log.e("success", skill_leaders_list + "");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<SkillLeader>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());

            }
        });

    }

    public void updateUi() {
        if (learningLeaders && skillIq) {
            sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), gadsLeaders_list, skill_leaders_list);

            LearningLeader.gadsLeader = gadsLeaders_list;
            SkillIQLeaders.skillTopLearners = skill_leaders_list;

            viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);
            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);

        }
    }


}