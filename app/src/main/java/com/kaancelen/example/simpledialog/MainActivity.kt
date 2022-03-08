package com.kaancelen.example.simpledialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog = SimpleDialog.newInstance(
            iconResId = R.drawable.ic_success,
            titleResId = R.string.title,
            description = getString(R.string.description),
            positiveButtonResId = R.string.positive_button_label,
            negativeButtonResId = R.string.negative_button_label
        )
        dialog.setOnPositiveClickListener {
            Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_LONG).show()
        }
        dialog.setOnNegativeClickListener {
            Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.dialog_button).setOnClickListener {
            dialog.show(supportFragmentManager, SimpleDialog.TAG)
        }
    }
}