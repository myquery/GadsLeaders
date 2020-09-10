package com.example.gadsleaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//private static SUBMIT_URL = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse";
public interface GadsInterface {
    @GET("hours")
    Call<List<GadsLeader>> getGadsLearningLeaders();

}
