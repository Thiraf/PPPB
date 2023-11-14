package com.example.pertemuan5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG= "MainActivityLifecycle"

    private lateinit var binding : ActivityMainBinding

    companion object{
        const val EXTRA_NAME="exstra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            btnToSecond.setOnClickListener{
                val intentToSecondActivity =
                    Intent(this@MainActivity,SecondActivity::class.java)


                val name = editTxtName.text.toString()
                intentToSecondActivity.putExtra(EXTRA_NAME,name)
                startActivity(intentToSecondActivity)
            }
        }
        Log.d(TAG,"oncreate dipanggil")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume dipanggil")
    }
//    onPause,onStop,onDestroy
}