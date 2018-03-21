package com.example.drodrigues.heroespoc.gateway.network;

import android.support.annotation.NonNull;

import com.example.drodrigues.heroespoc.infrastructure.Constants.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BackendIntegrator {

    private static final String BASE_URL = "http://gateway.marvel.com/";

    private static final OkHttpClient.Builder httpClient = new OkHttpClient
            .Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS);

    private static final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create());

    private static <S> S createServiceMarvelAuthentication(final Class<S> serviceClass) {
        httpClient.interceptors().clear();
        final MarvelAuthenticationInterceptor authenticationInterceptor = new MarvelAuthenticationInterceptor();
        httpClient.addInterceptor(authenticationInterceptor);

        final Retrofit retrofit = builder
                .client(httpClient.build())
                .baseUrl(BASE_URL)
                .build();

        return retrofit.create(serviceClass);
    }

    public static final class MarvelAuthenticationInterceptor implements  Interceptor {

        private static final String TS = "ts";
        private static final String TS_VALUE = new Date().toString();;

        private static final String API_KEY = "apikey";
        private static final String API_KEY_VALUE = "a48c79013f1b58d55d9cec2e8274b0b6";

        private static final String HASH = "hash";
        private static final String PRIVATE_KEY = "8ebf9b0625bb429687b447a4aed06cf1542b0332";

        @Override
        public Response intercept(@NonNull final Chain chain) throws IOException {
            Request request = chain.request();
            final HttpUrl originalUrl = request.url();

            final String hash = StringUtils.md5(TS + PRIVATE_KEY + API_KEY_VALUE);

            final HttpUrl url = originalUrl.newBuilder()
                    .addQueryParameter(TS, TS_VALUE)
                    .addQueryParameter(API_KEY, API_KEY_VALUE)
                    .addQueryParameter(HASH, hash)
                    .build();

            request = request.newBuilder().url(url).build();

            return chain.proceed(request);
        }
    }
}
