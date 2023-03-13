package com.example.push_notification.Utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class MainUitls {


    fun  showDialog(
        context: Context?,
        title: String?,
        msg: String?,
        ok: DialogInterface.OnClickListener?,
        close: DialogInterface.OnClickListener?
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton("OK", ok)
            .setNegativeButton("CLOSE", close)
        val alert: AlertDialog = builder.create()
        alert.show()
    }
}
