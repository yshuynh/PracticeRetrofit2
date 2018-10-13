package com.example.vu.practiceretrofit2.retrofit2;

public class APIUtils {
    public static final String Base_Url = "https://api.github.com/";
    public static DataClient getData() {
        return RetrofitClient.getClient(Base_Url).create(DataClient.class);
    }
}
