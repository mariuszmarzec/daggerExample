package marzec.pl.daggerexample.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import dagger.MapKey
import kotlinx.android.synthetic.main.activity_main.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.di.ExampleEnum
import java.lang.StringBuilder
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var setOfStrings: Set<String>

    @Inject
    lateinit var mapStringToString: Map<String, String>

    @Inject
    lateinit var mapMaxValues: Map<Class<*>, String>

    @Inject
    lateinit var mapEnumToIn: Map<ExampleEnum, Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).appComponent
        appComponent.mainActivityComponent().inject(this)

        singletonButton.setOnClickListener {
            val text = setOfStrings.fold(StringBuilder()) { sb, it -> sb.append(it)}.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        activityScopeButton.setOnClickListener {
            val text = mapStringToString.entries.fold(StringBuilder()) { sb, it ->
                sb.append(it.key).append(" ").append(it.value).append("\n")
            }.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        secondComponentButton.setOnClickListener {
            Toast.makeText(this, mapMaxValues[Long::class.java], Toast.LENGTH_SHORT).show()
        }
    }

}