package com.example.midtermaasrithabhimisetty

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class MainActivity : AppCompatActivity() {

    private lateinit var meterInput: EditText
    private lateinit var millimeterOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meterInput = findViewById(R.id.meterInput)
        millimeterOutput = findViewById(R.id.millimeterOutput)

        findViewById<Button>(R.id.convertButton).setOnClickListener {
            val meterString = meterInput.text.toString().trim()
            if (meterString.isEmpty()) {
                showError("Please enter a value in meters.")
                return@setOnClickListener
            }

            try {
                val meters = meterString.toDouble()
                val millimeters = meters * 1000
                millimeterOutput.text = "Millimeters: $millimeters"
            } catch (e: NumberFormatException) {
                showError("Please enter a valid number.")
            }
        }
    }

    private fun showError(message: String) {
        millimeterOutput.text = message


    }
}
