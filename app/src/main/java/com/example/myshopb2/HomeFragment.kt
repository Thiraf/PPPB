package com.example.myshopb2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myshopb2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding :FragmentHomeBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            val action = HomeFragmentDirections.actionHomeFragment2ToCheckOutFragment(productText.text.toString())
            btnBuy.setOnClickListener{
                findNavController().navigate(action)
            }
        }
    }


}