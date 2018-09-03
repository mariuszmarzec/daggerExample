package marzec.pl.daggerexample.ui.hello

import android.content.Context
import dagger.Module
import dagger.Provides
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.di.ActivityScope

@Module
class HelloModule {

    @Provides
    @ActivityScope
    fun provideHello(context: Context): String = context.getString(R.string.hello_world)
}