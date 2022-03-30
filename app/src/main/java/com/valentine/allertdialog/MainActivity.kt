package com.valentine.allertdialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnDialogStandard: Button
    private lateinit var btnDialogPositiveNegative: Button
    private lateinit var btnCustomDialog: Button
    private lateinit var btnTutup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDialogStandard = findViewById(R.id.btnDialogStandard)
        btnCustomDialog = findViewById(R.id.btnCustomDialog)
        btnDialogPositiveNegative = findViewById(R.id.btnDialogPositiveNegative)
//        btnTutup = view.findViewBy(R.id.btnTutup)


        btnDialogStandard.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Cancelable")
            dialog.setMessage("Dialog cancelable bisa ditutup dengan klik bagian luar dialog")
            dialog.setCancelable(true)
            dialog.show()

        }
        btnDialogPositiveNegative.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Dialog Dengan Button")
            dialog.setMessage("Dialog Dengan Button untuk berbagai Aksi")
            dialog.setIcon(R.mipmap.ic_launcher)

            dialog.setCancelable(false)
            dialog.setPositiveButton("Positive Button") { dialogInterface, p1 ->
                Toast.makeText(this, "Positive Button Clicked", Toast.LENGTH_LONG).show()
            }

            dialog.setNegativeButton("Negative Button") { dialogInterface, p1 ->
                Toast.makeText(this, "Negative Button Clicked", Toast.LENGTH_LONG).show()
            }

            dialog.setNeutralButton("Neutral Button") { dialogInterface, p1 ->
                Toast.makeText(this, "Neutral Button Clicked", Toast.LENGTH_LONG).show()
            }

            dialog.show()

        }
        btnCustomDialog.setOnClickListener {

            val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
            btnTutup = view.findViewById(R.id.btnTutup)
            val dialogBuilder = AlertDialog.Builder(this)
            dialogBuilder.setView(view)

            val dialog = dialogBuilder.create()

            btnTutup.setOnClickListener {
                Toast.makeText(this, "Custom Dialog Closed", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }

            dialog.show()
        }


    }
}


