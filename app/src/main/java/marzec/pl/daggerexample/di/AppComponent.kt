package marzec.pl.daggerexample.di

import android.app.Application
import android.content.Context
import android.util.Log
import dagger.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.ui.main.MainActivity
import javax.inject.Named
import dagger.Subcomponent




@Component(modules = [ApplicationModule::class])
interface AppComponent {

    fun mainActivityComponent(): MainActivityComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}

@Module
abstract class ApplicationModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): MainActivityComponent
    }

    fun inject(app: MainActivity)
}

@Module
class MainActivityModule {

    @Provides
    fun provideAppName(context: Context): String {
        return context.getString(R.string.app_name)
    }

}
