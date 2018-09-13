package marzec.pl.daggerexample.di

import android.app.Activity
import marzec.pl.daggerexample.ui.main.BaseComponent

object DependencyInjection {

    fun <T : Activity> inject(ob: T) {
        val application = ob.application
        if (application is HasComponentsBuilderMap) {
            (application.getMap()[ob::class.java]?.get() as BaseComponent.BaseBuilder<T>)
                    .instance(ob)
                    .build()
                    .inject(ob)
        }
    }

}