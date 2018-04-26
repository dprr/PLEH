package com.example.d.pleh;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "???????????";

    public static PlehAPI getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(PlehAPI.class);
    }
}
