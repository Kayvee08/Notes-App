package com.example.todo_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class NotesAdapter(private var notesList:List<EmpModelClass>):
RecyclerView.Adapter<NotesAdapter.MyViewHolder>(){
    internal class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var title: TextView = view.findViewById(R.id.titles)
        var yId: TextView = view.findViewById(R.id.yourId)
        var descriPtion: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.outputcard, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note:EmpModelClass = notesList[position]
        holder.title.text = note.userTitle
        holder.yId.text = note.userId.toString()
        holder.descriPtion.text = note.userDesc
    }
}