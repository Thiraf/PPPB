package com.example.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.ActivityId
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.example.first.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            textNumber.text= number.toString()
            btnCount.setOnClickListener{
                number++
                textNumber.text= number.toString()
            }
            btnToast.setOnClickListener {
                Toast.makeText(this@MainActivity, "Count$number", Toast.LENGTH_SHORT).show()

            }
        }


//        val text_View = findViewById<TextView>(R.id.hello_text_View)
//        text_View.text = "Kelas B2"

        //comment 1
    }
}