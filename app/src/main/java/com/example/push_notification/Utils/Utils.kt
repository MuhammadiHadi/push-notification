package com.example.push_notification.Utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainUitls {
    fun showToast(context: Context?, msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showDialog(
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
    object MySnackbar {
        private var snackbar: Snackbar? = null

        fun showSnackbar(view: View, message: String) {
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT).setAction("action"){

            }
            snackbar?.show()


        }

        fun dismissSnackbar() {
            snackbar?.dismiss()
        }




    }
}


