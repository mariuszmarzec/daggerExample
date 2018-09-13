package marzec.pl.daggerexample.ui.hello

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.di.DependencyInjection
import javax.inject.Inject
import javax.inject.Provider

class HelloActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentBuilder: Provider<HelloFragmentComponent.Builder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DependencyInjection.inject(this)
        setContentView(R.layout.activity_hello)
    }

}
