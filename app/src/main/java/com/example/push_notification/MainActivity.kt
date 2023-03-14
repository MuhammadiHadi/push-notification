package com.example.push_notification

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings.Secure
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.push_notification.Utils.MainUitls
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
//    var toolbar: Toolbar? = null
    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val  khan=MainUitls()
        val alert=this.findViewById<Button>(R.id.dialog)
        val button=this.findViewById<Button>(R.id.button2)
        val buttonactivity=this.findViewById<Button>(R.id.Activity)
        val home=this.findViewById<View>(R.id.home)
        val setting=this.findViewById<View>(R.id.nav_settings)
        val search=this.findViewById<View>(R.id.nav_search)
    val constraintLayout=this.findViewById<ConstraintLayout>(R.id.constraintLayout)
    val progress=this.findViewById<ProgressBar>(R.id.progressBar)
    val text=this.findViewById<TextView>(R.id.textView4)

//        val menu=this.findViewById<TextView>(R.id.menu)
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

    constraintLayout.setOnClickListener{
        progress.visibility=View.VISIBLE
        text.visibility=View.INVISIBLE
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
          Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
            progress.visibility=View.INVISIBLE
            text.visibility=View.VISIBLE
        },3000)

    }
        button.setOnClickListener {






            val snackbar =
                Snackbar.make(home, "Snackbar With Action", Snackbar.LENGTH_SHORT)
            snackbar.setAction("UNDO")
            { Toast.makeText(applicationContext, "Undo action", Toast.LENGTH_SHORT).show() }
            snackbar.show()
            replaceFragment(SimpleFragment())
        }
      setting.setOnClickListener{
          Toast.makeText(this,"Setting",Toast.LENGTH_SHORT).show()
      }
//      menu.setOnClickListener{
//
//      }
    search.setOnClickListener{
        Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show()
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


