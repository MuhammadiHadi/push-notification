package com.example.push_notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlin.concurrent.fixedRateTimer

class ChildFragment:Fragment() {
    private lateinit var ChildFragment: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ChildFragment= layoutInflater.inflate(R.layout.child_fragment,container,false)

        val button=ChildFragment?.findViewById<Button>(R.id.button3)
        val buttonback=ChildFragment?.findViewById<Button>(R.id.backButton)
        button?.setOnClickListener {
            replaceFragment(ChildTwoFragment())

      Toast.makeText(ChildFragment.context,"Hello",Toast.LENGTH_SHORT).show()
//            (requireActivity() as MainActivity).onBackPressed()
        }

        buttonback?.setOnClickListener {



            val fragmentManager: FragmentManager = parentFragmentManager
            fragmentManager.popBackStack()
        }



        return ChildFragment
    }
    fun replaceFragment(Fragment: Fragment){
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.home  , Fragment)
        fragmentTransaction.addToBackStack(null).commit()
    }
}