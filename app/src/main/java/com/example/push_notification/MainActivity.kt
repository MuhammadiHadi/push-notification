package com.example.push_notification

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Secure
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.push_notification.Utils.MainUitls
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val  khan=MainUitls()
        val alert=this.findViewById<Button>(R.id.dialog)
        val button=this.findViewById<Button>(R.id.button2)
        val buttonactivity=this.findViewById<Button>(R.id.Activity)
        val home=this.findViewById<View>(R.id.home)
        val android_id = Secure.getString(
            this.contentResolver,
            Secure.ANDROID_ID
        )
        println("Hello Dear$android_id")
        Log.d("Android", "AndHeello meer$android_id")

        alert.setOnClickListener {
            khan.showDialog(
                context = this,
                title = "Message",
                msg = "This is a Message for all User",
                ok = { dialog, which -> dialog.cancel() },
                close = { dialog, which -> dialog.cancel()}

            )



        }
        button.setOnClickListener {






            val snackbar =
                Snackbar.make(home, "Snackbar With Action", Snackbar.LENGTH_SHORT)
            snackbar.setAction("UNDO")
            { Toast.makeText(applicationContext, "Undo action", Toast.LENGTH_SHORT).show() }
            snackbar.show()
            replaceFragment(SimpleFragment())
        }


        buttonactivity.setOnClickListener {

            val intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("name","Meer Hadi")
            intent.putExtra("profession","Android Dev")
            startActivity(intent)
        }

    }




    fun replaceFragment(Fragment: Fragment){
        val fragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home,Fragment)
        fragmentTransaction.addToBackStack(null).commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0)
            super.onBackPressed()
        else
            supportFragmentManager.popBackStack()

    }



}


