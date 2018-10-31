package com.parthdave93.kotlindaggerdemo.di.network

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.parthdave93.kotlindaggerdemo.data.Prefs
import com.parthdave93.kotlindaggerdemo.network.WebApi
import com.parthdave93.kotlindaggerdemo.utils.NetworkMockInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Parth Dave email: parthdave93@gmail.com on 29-06-2018.
 */

@Module
open class NetworkModule @Inject constructor(val context: Context) {

    @Provides
    fun providesWebApi(retrofit : Retrofit): WebApi {
        Log.d("initLogs","providesWebApi called")
        return retrofit.create(WebApi::class.java)
    }

    @Provides
    fun retrofitDep( converterFactory: Converter.Factory, callAdapterFactory: CallAdapter.Factory, client : OkHttpClient): Retrofit{
        Log.d("initLogs","retrofitDep called")
        var retrofit = Retrofit.Builder()
                .baseUrl(WebApi.BASE_URL)
                .client(client)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory).build();

        return retrofit
    }

    @Provides
    fun converterFactory():Converter.Factory{
        Log.d("initLogs","converterFactory called")
        return GsonConverterFactory.create()
    }

    @Provides
    fun adapterFactory():CallAdapter.Factory{
        Log.d("initLogs","adapterFactory called")
        return RxJava2CallAdapterFactory.create()
    }


    @Provides
    fun client(prefs: Prefs,loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        Log.d("initLogs","providesWebApi called")
      /* var mockInterceptor = Interceptor{
            chain ->
                val request = chain?.request()?.newBuilder()
                if(prefs.getAuthToken()!=null)
                    request?.addHeader("Authorization",prefs.getAuthToken())

                chain?.proceed(request?.build())
       }*/
        return OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
//                .addInterceptor(mockInterceptor)
                .addInterceptor(NetworkMockInterceptor(context))
                .build()
    }

    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor{
        Log.d("initLogs","httpLoggingInterceptor called")
        return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}