package marzec.pl.daggerexample.di

import dagger.Component
import dagger.MembersInjector
import dagger.Module
import dagger.Provides
import marzec.pl.daggerexample.App

@Component()
interface AppComponent {

    fun inject(app: App)
}