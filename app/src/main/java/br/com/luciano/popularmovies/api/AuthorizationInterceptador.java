package br.com.luciano.popularmovies.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class AuthorizationInterceptador implements Interceptor {

    private static final String API_KEY_PARAM = "api_key";
    private static final String apiKey ="";//TODO Colocar a API KEY aqui

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        HttpUrl originalHttpUrl = originalRequest.url();
        HttpUrl newHttpUrl = originalHttpUrl.newBuilder()
                .setQueryParameter(API_KEY_PARAM,apiKey)
                .build();

        Request newRequest = originalRequest.newBuilder().url(newHttpUrl).build();
        Response newResponse = chain.proceed(newRequest);
        return newResponse;
    }
}
