package marzec.pl.daggerexample.di

import javax.inject.Inject
import javax.inject.Named

class UserName(
        val name: String,
        val surname: String) {

    val text
        get() = "$name $surname"
}