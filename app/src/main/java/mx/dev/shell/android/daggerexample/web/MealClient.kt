package mx.dev.shell.android.daggerexample.web

import mx.dev.shell.android.daggerexample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MealClient {

    fun getClient(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(getLoggingClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getLoggingClient(): OkHttpClient {
        val okHttpInterceptor = HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        return OkHttpClient.Builder()
            .addInterceptor(okHttpInterceptor)
            .build()
    }
}