package marzec.pl.daggerexample

import android.app.Application
import android.util.Log
import marzec.pl.daggerexample.di.DaggerAppComponent
import marzec.pl.daggerexample.di.UserName
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var userName: UserName

    override fun onCreate() {
        super.onCreate()
        userName = DaggerAppComponent.create().getUserName()

        Log.d("DaggerExampleApp", userName.text)
    }
}