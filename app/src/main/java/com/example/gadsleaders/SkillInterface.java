package com.example.gadsleaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillInterface {
    @GET("skilliq")
    Call<List<SkillLeader>> getGadsSkillLeaders();
}
