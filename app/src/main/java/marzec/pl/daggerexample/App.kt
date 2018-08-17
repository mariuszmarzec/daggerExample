package marzec.pl.daggerexample

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.MoreExecutors.directExecutor
import marzec.pl.daggerexample.di.DaggerAppComponent
import marzec.pl.daggerexample.di.ExecutorModule
import marzec.pl.daggerexample.di.UserName

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.builder()
                .executorModule(ExecutorModule)
                .build()
        component.inject(this)
        Futures.addCallback(component.getUserName(), object : FutureCallback<UserName> {
            override fun onSuccess(result: UserName?) {
                result?.let {
                    Log.d(App::class.java.simpleName, it.text)
                }
            }

            override fun onFailure(t: Throwable?) {
            }

        }, directExecutor())
    }
}