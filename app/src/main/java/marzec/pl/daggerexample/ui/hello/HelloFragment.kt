package marzec.pl.daggerexample.ui.hello

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_hello.*

import marzec.pl.daggerexample.R
import javax.inject.Inject

class HelloFragment : Fragment() {

    @Inject
    lateinit var helloWorld: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as HelloActivity).helloActivityComponent.helloFragmentComponent().inject(this)

        textView.text = helloWorld
    }
}
