package com.example.todo_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_layout.*

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val notesFragment = fragmentclass()
        val manager = supportFragmentManager
        val trsaction = manager.beginTransaction()
        trsaction.add(R.id.fragmentContainer,fragmentclass(),"fragment_layout").commit()
//        dialogEnterBtn.setOnClickListener(){
//            val titl = dialogTitle.text.toString()
//            val iden = dialogId.text.toString()
//            val descr = dialogDescription.text.toString()
//            saveRecord(iden,titl,descr)
//            startActivity(intent)
//        }

    }
//    fun entered(view :View){
//
//        //Toast.makeText(this,str.toString(),Toast.LENGTH_LONG).show()
//        if((view.id).equals(dialogEnterBtn.id)){
//        val iden = dialogId.text.toString()
//        val titl = dialogTitle.text.toString()
//        val descr = dialogDescription.text.toString()
//        saveRecord(iden,titl,descr)
//            val intent = Intent(this@NewActivity,MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
//    fun cancelled(view:View){
//        val intent = Intent(this@NewActivity,MainActivity::class.java)
//        startActivity(intent)
//    }
//    private fun saveRecord(identity:String,  titl:String ,  descripti:String) {
//        val databasehandler: dataBaseHandler = dataBaseHandler(this)
//        val status =
//            databasehandler.addNote(EmpModelClass(Integer.parseInt(identity), titl, descripti))
//        if (status > -1) {
//            Toast.makeText(applicationContext, "record saved", Toast.LENGTH_LONG).show()
//        }
//        else{
//            Toast.makeText(this,"There's some issue in saving this record",Toast.LENGTH_SHORT).show()
//        }
//    }

}