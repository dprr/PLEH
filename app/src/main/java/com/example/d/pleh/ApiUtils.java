package com.example.d.pleh;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "http://79.177.105.198:8080/";

    public static PlehAPI getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(PlehAPI.class);
    }
}
