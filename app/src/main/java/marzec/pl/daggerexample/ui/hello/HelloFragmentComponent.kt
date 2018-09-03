package marzec.pl.daggerexample.ui.hello

import dagger.Subcomponent
import marzec.pl.daggerexample.di.FragmentScope

@Subcomponent
@FragmentScope
interface HelloFragmentComponent {
    fun inject(fragment: HelloFragment)
}