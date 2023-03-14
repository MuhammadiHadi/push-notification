package com.example.push_notification.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.push_notification.R

class Drawer:Fragment() {

 lateinit var Drawer:View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       Drawer=layoutInflater.inflate(R.layout.drawer_layout,container,false)


        return  Drawer
    }
}