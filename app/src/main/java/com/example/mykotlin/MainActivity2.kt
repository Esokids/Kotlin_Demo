package com.example.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        supportActionBar!!.title = "Activity_Main2"

        /* Input from MainActivity EditText
        val message = intent.getStringExtra("key")
        name_textView.text = message
         */

//        val person = intent.extras!!.getSerializable("person") as Person // get Serializable
//        val person = intent.extras!!.getParcelable<Person>("person") // get Parcelable
        val person = intent.getParcelableExtra<Person>("person")
        val (name, age) = person!!
        name_textView.text = name
        age_textView.text = age.toString()

    }
}