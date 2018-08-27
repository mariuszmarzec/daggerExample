package marzec.pl.daggerexample

import android.app.Application
import android.util.Log
import marzec.pl.daggerexample.di.AppComponent
import marzec.pl.daggerexample.di.DaggerAppComponent
import marzec.pl.daggerexample.di.UserName
import javax.inject.Inject

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}