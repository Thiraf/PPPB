package com.example.pertemuan5

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.pertemuan5.MainActivity.Companion.EXTRA_NAME
import com.example.pertemuan5.ThirdActivity.Companion.EXTRA_ADDRESS
import com.example.pertemuan5.databinding.ActivityMainBinding
import com.example.pertemuan5.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
                val data = result.data

                val name = data?.getStringExtra(EXTRA_NAME)
                val address = data?.getStringExtra(EXTRA_ADDRESS)

                binding.txtName.text = "HELLO $name di $address"
            }
            //TODO : add function callback after next page is dismissed
//            update txtname dangan alamat dari activity 3

        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val name = intent.getStringExtra(EXTRA_NAME)
        with(binding){
            txtName.text = "Hello $name!"

            btnToThird.setOnClickListener{
                val intent = Intent(this@SecondActivity,ThirdActivity::class.java)
                    .apply { putExtra(EXTRA_NAME,name) }

                launcher.launch(intent)
            }

        }
    }
}