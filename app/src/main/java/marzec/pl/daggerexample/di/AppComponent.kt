package marzec.pl.daggerexample.di

import android.util.Log
import dagger.Component
import dagger.Module
import dagger.Provides
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.ui.main.MainActivity
import javax.inject.Named
import javax.inject.Qualifier

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(app: MainActivity)
}

@Module
class AppModule {

    @Named("Name")
    @Provides
    fun provideName(): String {
        Log.d("DaggerExampleApp", "provides name")
        return "Jan"
    }

    @Named("Surname")
    @Provides
    fun provideSurname(): String {
        Log.d("DaggerExampleApp", "provides surname")
        return "Kowalski"
    }

    @Provides
    fun provideUserName(@Named("Name") name: String,
                        @Named("Surname") surname: String): UserName {
        return UserName(name, surname)
    }
}