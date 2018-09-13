package marzec.pl.daggerexample

import android.app.Activity
import android.app.Application
import marzec.pl.daggerexample.di.DaggerAppComponent
import marzec.pl.daggerexample.di.HasComponentsBuilderMap
import marzec.pl.daggerexample.ui.main.BaseComponent
import javax.inject.Provider

class App : Application(), HasComponentsBuilderMap {

    lateinit var appComponent: BaseComponent<App>

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().instance(this).build()
    }

    override fun getMap(): Map<Class<out Activity>, @JvmSuppressWildcards Provider<BaseComponent.BaseBuilder<*>>> {
        return appComponent.getActivityBuilders()
    }
}