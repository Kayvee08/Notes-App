package com.example.todo_app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.enterdata.*

class MainActivity : AppCompatActivity() {
    val noteList = ArrayList<EmpModelClass>()
    private lateinit var notesAdapter:NotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity,NewActivity::class.java)
            startActivity(intent)

            //Shifted to a new Activity
//            val notesFragment = fragmentclass()
//            val manager = supportFragmentManager
//            val trsaction = manager.beginTransaction()
//            trsaction.add(R.id.fragmentContainer,fragmentclass(),"fragment_layout").commit()
            val snack = Snackbar.make(it,"You pressed Floating Action Button",Snackbar.LENGTH_LONG)
            snack.show()
        }
//        saveRecord()
        val recyclerView:RecyclerView= recyclerView
        viewRecord()
        notesAdapter  = NotesAdapter(noteList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter=notesAdapter
    }

    fun saveRecord() {
//        val identity = "9"
//        val titl = "Goto Ground"
//        val descripti = "Do some exercises"
//        val databasehandler: dataBaseHandler = dataBaseHandler(this)
//        val status =
//            databasehandler.addNote(EmpModelClass(Integer.parseInt(identity), titl, descripti))
//        if (status > -1) {
//            Toast.makeText(applicationContext, "record saved", Toast.LENGTH_LONG).show()
//        }
    }
    fun viewRecord(){
        val databasehandler: dataBaseHandler = dataBaseHandler(this)
        val emp: List<EmpModelClass> = databasehandler.viewEmployee()
        var empArrayId:String
        var empArrayName:String
        var empArrayEmail:String
        var index = 0
        for(e in emp){
            val em = EmpModelClass(0,"NoName","NoDesc")

            empArrayId = e.userId.toString()
            empArrayName = e.userTitle
            empArrayEmail = e.userDesc
            em.userId=empArrayId.toInt()
            em.userTitle = empArrayName
            em.userDesc=empArrayEmail
            noteList.add(em)
            index++
            Toast.makeText(this, "Viewing Record",Toast.LENGTH_SHORT).show()
        }
    }


}