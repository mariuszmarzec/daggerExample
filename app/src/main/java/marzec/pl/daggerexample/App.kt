package marzec.pl.daggerexample

import android.app.Application
import android.util.Log
import marzec.pl.daggerexample.di.DaggerAppComponent
import marzec.pl.daggerexample.di.UserName
import javax.inject.Inject

class App : Application() {

    val appComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
    }
}