package marzec.pl.daggerexample.di

import dagger.*
import java.util.*

@Component(modules = [AppModule::class])
interface AppComponent {

//    fun getInt(): Int
    fun mainActivityComponent(): MainActivityComponent
}

@Module
class AppModule {

    @Provides
    @Reusable
    fun provideInt(): Int = randomInt()
}

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun getInt(): Int
}

@Module
class MainActivityModule {
}

fun randomInt() = Random().nextInt(1000)