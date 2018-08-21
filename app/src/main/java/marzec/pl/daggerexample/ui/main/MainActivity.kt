package marzec.pl.daggerexample.ui.main

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.di.UserName
import java.util.*
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userName: Provider<UserName>

    @Inject
    lateinit var nickName: Optional<NickName>

    @TargetApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.inject(this)

        helloWorldButton.setOnClickListener {
            val nick = nickName.orElse(null)
            val name = if (nick != null) nick.text else userName.get().text
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        }
    }
}

class NickName {
    val text = "nick"
}