package marzec.pl.daggerexample.di

import dagger.*
import java.util.*
import dagger.Provides
import dagger.multibindings.*
import marzec.pl.daggerexample.ui.main.MainActivity
import kotlin.collections.Set


@Component(modules = [AppModule::class])
interface AppComponent {

    fun mainActivityComponent(): MainActivityComponent
}

@Module
class AppModule

@Subcomponent(modules = [MainActivityModule::class,
SetModule::class, StringModule::class, ClassKeyModule::class, CustomMapKeyModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}

@Module
class SetModule {
    @Provides
    @IntoSet
    fun provideOneString(): String {
        return "ABC"
    }

    @Provides
    @ElementsIntoSet
    fun provideSomeStrings(): Set<String> {
        return setOf("DEF", "GHI")
    }
}

@Module
class StringModule {
    @Provides
    @IntoMap
    @StringKey("1")
    fun provideStringToMap(): String {
        return "Jeden"
    }

    @Provides
    @IntoMap
    @StringKey("2")
    fun provideStringToMap2(): String {
        return "Dwa"
    }

}

@Module
class ClassKeyModule {
    @Provides
    @IntoMap
    @ClassKey(Long::class)
    fun provideLongMaxValue() : String {
        return Long.MAX_VALUE.toString()
    }

    @Provides
    @IntoMap
    @ClassKey(Short::class)
    fun provideShortMaxValue() : String {
        return Short.MAX_VALUE.toString()
    }
}

@Module
class CustomMapKeyModule {
    @Provides
    @IntoMap
    @ExampleEnumKey(ExampleEnum.NUMBER_1)
    fun provideStringWithEnum(): Int {
        return 1
    }
}

@Module
class MainActivityModule {

}

enum class ExampleEnum {
    NUMBER_1, NUMBER_2
}
@MapKey
annotation class ExampleEnumKey(val value: ExampleEnum)
