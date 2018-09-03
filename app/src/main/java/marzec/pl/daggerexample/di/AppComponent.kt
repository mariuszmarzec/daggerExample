package marzec.pl.daggerexample.di

import android.app.Application
import dagger.*
import marzec.pl.daggerexample.ui.hello.HelloActivityComponent
import marzec.pl.daggerexample.ui.main.MainActivityComponent
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun mainActivityComponent(): MainActivityComponent

    fun helloActivityComponent(): HelloActivityComponent
}


