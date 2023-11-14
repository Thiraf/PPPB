package com.example.pertemuan10

import android.location.GnssAntennaInfo.Listener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            rvStudent.apply {
                adapter = StudentAdapater(generateStudentData()){student ->
                    Toast.makeText(
                        this@MainActivity,
                        "This is ${student.name},and he/she likes to ${student.hobby}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
    fun generateStudentData():List<Student>{
        return listOf(
            Student(name = "Rambu",hobby = "Memancing"),
            Student(name = "Aziz",hobby = "Billiard"),
            Student(name = "Rua",hobby = "Golf"),
            Student(name = "Darel",hobby = "Jajan"),
            Student(name = "Wildan",hobby = "Putus nyambung")
        )
    }
}