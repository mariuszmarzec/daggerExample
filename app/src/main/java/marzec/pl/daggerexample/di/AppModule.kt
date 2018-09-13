package marzec.pl.daggerexample.di

import android.app.Activity
import android.content.Context
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.ui.hello.HelloActivity
import marzec.pl.daggerexample.ui.hello.HelloActivityComponent
import marzec.pl.daggerexample.ui.main.BaseComponent
import marzec.pl.daggerexample.ui.main.MainActivity
import marzec.pl.daggerexample.ui.main.MainActivityComponent
import kotlin.reflect.KClass

@Module(subcomponents = [MainActivityComponent::class, HelloActivityComponent::class])
interface AppModule {
    @Binds
    fun bindContext(application: App): Context

    @Multibinds
    fun bindActivityBuilders() : Map<KClass<out Activity>, BaseComponent.BaseBuilder<*>>

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    fun bindMainActivityBuilder(builder: MainActivityComponent.Builder): BaseComponent.BaseBuilder<*>

    @Binds
    @IntoMap
    @ActivityKey(HelloActivity::class)
    fun bindHelloActivityBuilder(builder: HelloActivityComponent.Builder): BaseComponent.BaseBuilder<*>
}

@MapKey
annotation class ActivityKey(val value: KClass<out Activity>)