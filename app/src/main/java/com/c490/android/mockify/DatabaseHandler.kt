package com.c490.android.mockify

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "mockifyDB"
val TABLE_NAME = "mockedMessages"
val COL_INPUT = "inputMessage"
val COL_MOCK = "mockedText"
val COL_ID = "id"

class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE" + TABLE_NAME + " (" +
                COL_ID + "INTEGER PRIMARY KEY AUTO INCREMENT," +
                COL_INPUT + "VARCHAR(256)"
                COL_MOCK + "VARCHAR(256)"
        db?.execSQL(createTable)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    fun insertData(user : MainActivity){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_MOCK, user.converted)
        cv.put(COL_INPUT, user.input)
        var result = db.insert(TABLE_NAME,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

    }
}
