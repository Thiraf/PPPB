package com.example.myshopb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myshopb2.databinding.FragmentCheckOutBinding
import com.example.myshopb2.databinding.FragmentHomeBinding

class CheckOutFragment : Fragment() {
    private lateinit var binding: FragmentCheckOutBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckOutBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            val args : CheckOutFragmentArgs by navArgs()
            txtProductName.setText(args.productName)

            btnDone.setOnClickListener {
                findNavController().navigateUp()
            }

            editAddress.setOnClickListener{
                val action = CheckOutFragmentDirections.actionCheckOutFragmentToAddressFragment()
                findNavController().navigate(action)
            }
            findNavController().currentBackStackEntry?.savedStateHandle?.let {
                handle->
                handle.getLiveData<String>("address")
                    .observe(viewLifecycleOwner){
                        res->
                        editAddress.setText(res)
                    }
            }
        }
    }
}