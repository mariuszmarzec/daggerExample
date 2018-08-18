package marzec.pl.daggerexample.di

import dagger.Component
import dagger.MembersInjector
import dagger.Module
import dagger.Provides
import marzec.pl.daggerexample.App
import java.lang.annotation.Documented
import javax.inject.Qualifier

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)
}

@Module
class AppModule {

    @Name
    @Provides
    fun provideName() = "Jan"

    @Surname
    @Provides
    fun provideSurname() = "Kowalski"
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Name

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Surname
