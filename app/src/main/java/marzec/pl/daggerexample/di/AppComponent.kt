package marzec.pl.daggerexample.di

import android.app.Application
import android.content.Context
import android.util.Log
import dagger.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.ui.main.MainActivity
import javax.inject.Named


@Component(modules = [AppModule::class, ApplicationModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
    fun inject(app: MainActivity)
}

@Module
abstract class ApplicationModule {
    @Binds
    abstract fun bindContext(application: Application): Context
}

@Module
class AppModule {

    @Provides
    fun provideAppName(context: Context): String {
        return context.getString(R.string.app_name)
    }
}

