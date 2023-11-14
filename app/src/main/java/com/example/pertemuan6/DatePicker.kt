package com.example.pertemuan6
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment


class DatePicker: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val mounthOfYear = calendar.get(Calendar.MONTH)
        val dayOfMounth = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            requireActivity(),
            activity as DatePickerDialog.OnDateSetListener,
            year,mounthOfYear,dayOfMounth
        )
    }
}