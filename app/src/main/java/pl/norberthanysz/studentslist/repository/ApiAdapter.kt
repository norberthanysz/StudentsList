package pl.norberthanysz.studentslist.repository

import okhttp3.OkHttpClient
import pl.norberthanysz.studentslist.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiAdapter {
    val apiClient: ApiClient = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiClient::class.java)
}