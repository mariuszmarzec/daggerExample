package marzec.pl.daggerexample.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.di.UserName
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userName: Provider<UserName>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.inject(this)

        helloWorldButton.setOnClickListener {
            Toast.makeText(this, userName.get().text, Toast.LENGTH_SHORT).show()
        }
    }
}
