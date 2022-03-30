package com.valentine.allertdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class AlertDialogFragment : DialogFragment() {
    lateinit var name: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //casting
        val edtName = view.findViewById<EditText>(R.id.edtName)
        val button = view.findViewById<Button>(R.id.fragment_dialog)

       //getdata
        button.setOnClickListener {
            name = edtName.text.toString().trim()
            Toast.makeText(requireContext(), name, Toast.LENGTH_LONG).show()
            dialog?.dismiss()
        }

    }

}