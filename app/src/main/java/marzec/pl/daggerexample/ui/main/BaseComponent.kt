package marzec.pl.daggerexample.ui.main

import android.app.Activity
import dagger.BindsInstance
import javax.inject.Provider
import kotlin.reflect.KClass

interface BaseComponent<T> {

    fun inject(ob: T)

    fun getActivityBuilders() : Map<Class<out Activity>, @JvmSuppressWildcards Provider<BaseBuilder<*>>>

    interface BaseBuilder<T> {

        @BindsInstance
        fun instance(instance: T) : BaseBuilder<T>

        fun build(): BaseComponent<T>

    }
}