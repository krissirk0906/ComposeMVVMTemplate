package com.juneNine.composeWithMVVM.di

import android.app.Application
import com.juneNine.composeWithMVVM.MyRepository
import com.juneNine.composeWithMVVM.MyRepositoryImplement
import com.juneNine.composeWithMVVM.UserRepository
import com.juneNine.composeWithMVVM.UserRepositoryImplement
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val BASE_URL = "https://quotable.io/"

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit) = retrofit.create(MyApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: MyApi, app: Application): MyRepository {
        return MyRepositoryImplement(api, app)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: MyApi, app: Application): UserRepository {
        return UserRepositoryImplement(api, app)
    }
}