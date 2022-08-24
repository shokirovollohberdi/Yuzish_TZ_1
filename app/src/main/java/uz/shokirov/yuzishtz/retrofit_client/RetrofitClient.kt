package uz.shokirov.yuzishtz.retrofit_client

import android.content.ContentValues
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.shokirov.yuzishtz.service.AuthService
import uz.shokirov.yuzishtz.token

object RetrofitClient {

    private val client = OkHttpClient.Builder().addInterceptor { chain: Interceptor.Chain ->
        val newRequest: Request = chain.request().newBuilder()
            .header(
                "Authorization", " Bearer $token"
            )
            .build()
        chain.proceed(newRequest)
    }.build()


    private const val BASE_URL = "https://back.yuvish.uz/"
    fun getRetrofit(): AuthService {
        Log.e(ContentValues.TAG, "getRetrofit: $token")
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(AuthService::class.java)
    }

}