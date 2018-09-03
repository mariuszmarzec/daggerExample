package marzec.pl.daggerexample.ui.hello

import dagger.Subcomponent
import marzec.pl.daggerexample.di.ActivityScope

@ActivityScope
@Subcomponent(modules = [HelloModule::class])
interface HelloActivityComponent {
    fun inject(activity: HelloActivity)

    fun helloFragmentComponent(): HelloFragmentComponent
}