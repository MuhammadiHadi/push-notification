package com.example.push_notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class ChildTwoFragment:Fragment()  {
    private lateinit var Child: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Child= layoutInflater.inflate(R.layout.child_two_layout,container,false)

        val button=Child?.findViewById<Button>(R.id.button4)

        button?.setOnClickListener {
            Toast.makeText(Child.context,"Hello", Toast.LENGTH_SHORT).show()
//            (requireActivity() as MainActivity).onBackPressed()
        }

        button?.setOnClickListener {



            val fragmentManager: FragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
        }



        return Child
    }
}