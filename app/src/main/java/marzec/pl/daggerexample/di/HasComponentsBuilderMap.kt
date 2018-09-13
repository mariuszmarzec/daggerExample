package marzec.pl.daggerexample.di

import android.app.Activity
import marzec.pl.daggerexample.ui.main.BaseComponent
import javax.inject.Provider

interface HasComponentsBuilderMap {
    fun getMap(): Map<Class<out Activity>, @JvmSuppressWildcards Provider<BaseComponent.BaseBuilder<*>>>
}