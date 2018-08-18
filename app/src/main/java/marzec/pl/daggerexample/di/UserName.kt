package marzec.pl.daggerexample.di

class UserName constructor(
        private val name: String,
        private val surname: String
) {

    val text
        get() = "$name $surname"
}