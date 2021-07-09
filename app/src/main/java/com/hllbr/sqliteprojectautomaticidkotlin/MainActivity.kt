package com.hllbr.sqliteprojectautomaticidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians(ıd INTEGER PRIMARY KEY,name VARCHAR,age INT)")
            //myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('james',50)")
            //myDatabase.execSQL("INSERT INTO musinians(name,age) VALUES('lars',65)")
            //myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('Bart',2)")
            myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('hllbr',25)")
            var cursor = myDatabase.rawQuery("SELECT * FROM musicians",null)
            var nameIx = cursor.getColumnIndex("name")
            var ageId = cursor.getColumnIndex("age")
            var ıdIx = cursor.getColumnIndex("ıd")
            while (cursor.moveToNext()){
                println("name : "+cursor.getString(nameIx))
                println("age : "+cursor.getInt(ageId))
                println("ıd : "+cursor.getInt(ıdIx))
            }
            cursor.close()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}