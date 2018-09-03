package marzec.pl.daggerexample

import android.app.Application
import marzec.pl.daggerexample.di.AppComponent
import marzec.pl.daggerexample.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
    }
}