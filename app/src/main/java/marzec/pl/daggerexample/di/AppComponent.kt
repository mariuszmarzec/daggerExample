package marzec.pl.daggerexample.di

import dagger.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.ui.hello.HelloActivityComponent
import marzec.pl.daggerexample.ui.main.BaseComponent
import marzec.pl.daggerexample.ui.main.MainActivityComponent
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : BaseComponent<App> {

    @Component.Builder
    interface Builder : BaseComponent.BaseBuilder<App> {
        override fun build(): AppComponent
    }
}


