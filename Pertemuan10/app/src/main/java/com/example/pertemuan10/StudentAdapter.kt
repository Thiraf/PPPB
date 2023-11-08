package com.example.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan10.databinding.ItemStudentBinding

typealias OnClickStudent = (Student) -> Unit

class StudentAdapater (private val listStudent : List<Student>, private val onClickStudent: OnClickStudent) : RecyclerView.Adapter<StudentAdapater.ItemStudentViewHolder>() {
    inner class ItemStudentViewHolder (private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (data : Student){
            with(binding){
                hobbyTxt.text = data.hobby
                nameTxt.text = data.name

//                Ketika suatu baris pada suatu data student di pencet, fungsi dibawah ini yang dipanggil
                itemView.setOnClickListener{
                    onClickStudent(data)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }
}