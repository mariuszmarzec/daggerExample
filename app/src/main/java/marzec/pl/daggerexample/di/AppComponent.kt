package marzec.pl.daggerexample.di

import android.util.Log
import dagger.Component
import dagger.Module
import dagger.Provides
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.ui.main.MainActivity
import marzec.pl.daggerexample.ui.main.NickName
import javax.inject.Named
import javax.inject.Qualifier
import dagger.BindsOptionalOf



@Component(modules = [AppModule::class, NickNameModule::class])
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

    // uncomment to make to provide optional
    // @Provides fun provideNickName() = NickName()
}

@Module
abstract class NickNameModule {
    @BindsOptionalOf
    internal abstract fun bindNickName(): NickName
}