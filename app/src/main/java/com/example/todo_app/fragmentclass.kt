package com.example.todo_app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.todo_app.R
import kotlinx.android.synthetic.main.fragment_layout.*

class fragmentclass:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater!!.inflate(R.layout.fragment_layout,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogEnterBtn.setOnClickListener {

                val iden = dialogId.text.toString()
                val titl = dialogTitle.text.toString()
                val descr = dialogDescription.text.toString()
            saveRecord(iden,titl,descr)
            val intent = Intent(activity,MainActivity::class.java)
            startActivity(intent)

        }

        dialogCancelBtn.setOnClickListener(){
            val intent = Intent(activity,MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
    private fun saveRecord(identity: String, titl: String, descripti: String) {
        val databasehandler: dataBaseHandler? = context?.let { dataBaseHandler(it) }
        val status =
            databasehandler?.addNote(EmpModelClass(Integer.parseInt(identity), titl, descripti))
        if (status != null) {
            if (status > -1) {
                Toast.makeText(context, "record saved", Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(context,"There's some issue in saving this record", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


