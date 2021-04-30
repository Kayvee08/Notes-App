package com.example.todo_app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import java.util.*
import kotlin.collections.ArrayList

class dataBaseHandler(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object{
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="NOTES"
        private val TABLE_CONTACTS="NotesTable"
        private val KEY_ID="id"
        private val KEY_TITLE = "TITLE"
        private val KEY_DESC="DESCRIPTION"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_CONTACTS+" ("+
                KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE +" TEXT," +
                KEY_DESC+ " TEXT)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)
        onCreate(db)
    }

    fun addNote(emp:EmpModelClass):Long{
        val db = this.writableDatabase
        val contentValues= ContentValues()
        contentValues.put(KEY_ID,emp.userId)
        contentValues.put(KEY_TITLE,emp.userTitle)
        contentValues.put(KEY_DESC,emp.userDesc)
        val success = db.insert(TABLE_CONTACTS,null,contentValues)
        db.close()
        return success
    }

    fun viewEmployee():List<EmpModelClass>{
        val empList:ArrayList<EmpModelClass> = ArrayList<EmpModelClass>()
        val selectQuery = "SELECT * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        var cursor:Cursor? =null
        try{
            cursor = db.rawQuery(selectQuery, null)
        }catch (e:SQLiteException){
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var userId:Int
        var userTitle:String
        var userDesc:String
        if(cursor.moveToFirst()){
            do{
                userId= cursor.getInt(cursor.getColumnIndex(KEY_ID))
                userTitle = cursor.getString(cursor.getColumnIndex(KEY_TITLE))
                userDesc = cursor.getString(cursor.getColumnIndex(KEY_DESC))
                val emp = EmpModelClass(userId = userId,userTitle = userTitle, userDesc = userDesc)
                empList.add(emp)
            }while(cursor.moveToNext())
        }
        return empList
    }



}