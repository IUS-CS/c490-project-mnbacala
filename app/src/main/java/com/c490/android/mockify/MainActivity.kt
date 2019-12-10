package com.c490.android.mockify

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    internal lateinit var editText: EditText
    internal lateinit var text: TextView
    internal lateinit var button: Button
    private lateinit var button2: Button
    internal lateinit var input: String
    internal lateinit var converted: String
    internal lateinit var clipboard:ClipboardManager
    internal lateinit var clip:ClipData


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.mockButton)
        button2 = findViewById(R.id.copyButton)
        editText = findViewById(R.id.enterText) as EditText
        text = findViewById<TextView>(R.id.tConverted)

        button.setOnClickListener {
            Log.v("EditText", editText.getText().toString())
            input = editText.getText().toString()
            converted = mockMe(input)
            text.setText(converted)
        }
        copyButton.setOnClickListener {
            clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val inputText:String
            inputText = text.getText().toString()
            clip = ClipData.newPlainText("Text",inputText)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(getApplicationContext(), "Text Copied", Toast.LENGTH_SHORT).show()
        }
    }
    companion object{
        fun mockMe(input: String): String {
            var result = ""
            for (i in input.indices) {
                result += if ((i % 2 and i % 4 == 0)) {
                    Character.toLowerCase(input[i])
                } else Character.toUpperCase(
                    input.get(i)
                )
            }
            return result
        }
    }
}


