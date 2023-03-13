package com.example.push_notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class SimpleFragment:Fragment() {
   private lateinit var simpleFragment:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        simpleFragment= layoutInflater.inflate(R.layout.simple_lauout,container,false)

        val button=simpleFragment?.findViewById<Button>(R.id.button)
        val next=simpleFragment?.findViewById<Button>(R.id.nextfragment)
        button?.setOnClickListener {

            (requireActivity() as MainActivity).onBackPressed()
        }

                      next?.setOnClickListener {
                      replaceFragment(ChildFragment())
  }


        return simpleFragment
    }
    fun replaceFragment(Fragment: Fragment){
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.home  , Fragment)
        fragmentTransaction.addToBackStack(null).commit()
    }


}