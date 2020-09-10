package com.example.gadsleaders;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ProjectSubmit {
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<ProjectEntryForm> submitProject(
            @Field("emailAddress") String emailAddress,
            @Field("name") String name,
            @Field("lastName") String lastName,
            @Field("linkToGithub") String linkToGithub
    );

}
