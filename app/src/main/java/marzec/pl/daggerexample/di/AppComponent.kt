package marzec.pl.daggerexample.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import java.util.*
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

//@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Named("Application")
    fun getInt(): Int

    fun mainActivityComponent(): MainActivityComponent
}

@Module
class AppModule {

    @Provides
    @Named("Application")
//    @Singleton
    fun provideInt(): Int = randomInt()
}

//@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Named("Activity")
    fun getInt(): Int
}

@Module
class MainActivityModule {

    @Provides
    @Named("Activity")
//    @ActivityScope
    fun provideInt(): Int = randomInt()
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope


fun randomInt() = Random().nextInt(1000)