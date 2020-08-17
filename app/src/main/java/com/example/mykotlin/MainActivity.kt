package com.example.mykotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mEditText: EditText
    private lateinit var mButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindWidgets()
        setEvents()
        btn_submit.setOnClickListener { checkSelected() }
    }

    private fun bindWidgets() {
        mEditText = findViewById<EditText>(R.id.editText)
        mButton = findViewById<Button>(R.id.button)
    }

    private fun setEvents() {
        mButton.setOnClickListener(View.OnClickListener { v ->
            Toast.makeText(applicationContext, "Hi " + mEditText.text, Toast.LENGTH_LONG).show()

            // Intent to next Activity ( Change Page )
            val intent = Intent(this, MainActivity2::class.java)

            /* From Input EditText
            intent.putExtra("key", mEditText.text.toString())
             */

            val bundle = Bundle()
//            bundle.putSerializable("person", Person("Jack", 20)) // Serializable
            bundle.putParcelable("person", Person("Jack", 20)) // Parcelable
            intent.putExtras(bundle)

            startActivity(intent);
        })
    }

    private fun checkSelected() {
        val selectedId = radioGroup.checkedRadioButtonId

        if (selectedId == -1) {
            Toast.makeText(applicationContext, "Please selected an option", Toast.LENGTH_LONG).show()
        } else {
            val selectedValue = findViewById<RadioButton>(selectedId).text
            Toast.makeText(applicationContext, "You selected : $selectedValue", Toast.LENGTH_LONG).show()
        }
    }
}