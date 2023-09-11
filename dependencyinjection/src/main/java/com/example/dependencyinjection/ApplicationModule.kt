package com.example.dependencyinjection

import com.example.dependencyinjection.hiltimplementationforinterface.MyInterface
import com.example.dependencyinjection.hiltimplementationforinterface.MyInterfaceImplementer
import com.example.dependencyinjection.hiltimplementationforinterface.MyInterfaceImplementerSecond
import com.example.dependencyinjection.hiltimplementationforinterface.UserInterfaceSecond
//import com.example.dependencyinjection.hiltimplementationforinterface.MyInterfaceImplementerSecond
//import com.example.dependencyinjection.hiltimplementationforinterface.UserInterfaceSecond
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ApiKey

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class LibraryKey

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class MyInterfaceOne

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class MyInterfaceSecond


    @ApiKey
    @Provides
    @Singleton
    fun provideApiKey() = "Api Key 123"

    @LibraryKey
    @Provides
    @Singleton
    fun provideLibKey() = "Library Key 456"

    @Provides
    fun provideIntVal() = arrayListOf("Amir", "Rashid")

    @Singleton
    @Provides
    fun provideAppModuleTestClass(
        @ApiKey apiKe: String,
        @LibraryKey libraryKey: String
    ): AppModuleTestClass =
        AppModuleTestClass(apiKe, libraryKey)

    @MyInterfaceOne
    @Singleton
    @Provides
    fun providerFunction(): MyInterface {
        return MyInterfaceImplementer()
    }

    @MyInterfaceSecond
    @Singleton
    @Provides
    fun provideInterfaceSecond(): MyInterface {
        return MyInterfaceImplementerSecond()
    }


    @Provides
    @Singleton
    fun provideUserInterfaceSecond(
        @MyInterfaceOne myiInterfaceOne: MyInterface,
        @MyInterfaceSecond myiInterfaceSecond: MyInterface
    ) =
        UserInterfaceSecond(myiInterfaceOne, myiInterfaceSecond)

}