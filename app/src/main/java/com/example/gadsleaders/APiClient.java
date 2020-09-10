package com.example.gadsleaders;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APiClient {
    private static Retrofit retrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }

    private static Retrofit submitProjectRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }

    public static GadsInterface getGadsLearners() {
        GadsInterface gadsInterface = retrofitClient().create(GadsInterface.class);
        return gadsInterface;
    }

    public static SkillInterface getSkillLearners() {
        SkillInterface skillInterface = retrofitClient().create(SkillInterface.class);
        return skillInterface;
    }

    public static ProjectSubmit submitProject() {
        ProjectSubmit projectSubmitInterface = submitProjectRetrofit().create(ProjectSubmit.class);
        return projectSubmitInterface;
    }
}
