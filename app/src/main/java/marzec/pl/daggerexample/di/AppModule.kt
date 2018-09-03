package marzec.pl.daggerexample.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
interface AppModule {
    @Binds
    fun bindContext(application: Application): Context
}